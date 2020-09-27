package com.adscanal.sdk.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    static final int timeOut = 60 * 1000;

    private static CloseableHttpClient httpClient = null;

    private final static Object syncLock = new Object();
    private static final String ENCODE = "UTF-8";

    private static void config(HttpRequestBase httpRequestBase) {
        // 设置Header等
        httpRequestBase.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");

        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(timeOut)
                .setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
        httpRequestBase.setConfig(requestConfig);
    }

    /**
     * 获取HttpClient对象
     */
    public static CloseableHttpClient getHttpClient(String url) {
        String hostname = url.split("/")[2];
        int port = 80;
        if (hostname.contains(":")) {
            String[] arr = hostname.split(":");
            hostname = arr[0];
            port = Integer.parseInt(arr[1]);
        }
        if (httpClient == null) {
            synchronized (syncLock) {
                if (httpClient == null) {
                    httpClient = createHttpClient(200, 40, 100, hostname, port);
                }
            }
        }
        return httpClient;
    }

    /**
     * 创建HttpClient对象
     * 
     */
    public static CloseableHttpClient createHttpClient(int maxTotal,
                                                       int maxPerRoute, int maxRoute, String hostname, int port) {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory
                .getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory
                .getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder
                .<ConnectionSocketFactory> create().register("http", plainsf)
                .register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                registry);
        // 将最大连接数增加
        cm.setMaxTotal(maxTotal);
        // 将每个路由基础的连接增加
        cm.setDefaultMaxPerRoute(maxPerRoute);
        HttpHost httpHost = new HttpHost(hostname, port);
        // 将目标主机的最大连接数增加
        cm.setMaxPerRoute(new HttpRoute(httpHost), maxRoute);

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception,
                    int executionCount, HttpContext context) {
                // 如果已经重试了5次，就放弃
                if (executionCount >= 3) {
                    return false;
                }
                // 如果服务器丢掉了连接，那么就重试
                if (exception instanceof NoHttpResponseException) {
                    return true;
                }
                // 不要重试SSL握手异常
                if (exception instanceof SSLHandshakeException) {
                    return false;
                }
                // 超时
                if (exception instanceof InterruptedIOException) {
                    return false;
                }
                // 目标服务器不可达
                if (exception instanceof UnknownHostException) {
                    return false;
                }
                // 连接被拒绝
                if (exception instanceof ConnectTimeoutException) {
                    return false;
                }
                // SSL握手异常
                if (exception instanceof SSLException) {
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext
                        .adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                //.setRetryHandler(httpRequestRetryHandler)
                .build();

        return httpClient;
    }

    private static void setPostParams(HttpPost httpPost,
                                      Map<String, Object> params) throws UnsupportedEncodingException {
        List<NameValuePair> nvps = new ArrayList<>();
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, ENCODE));
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
    }

    /**
     * GET请求URL获取内容
     * 
     * @param url
     * @return
     */
    public static String post(String url, Map<String, Object> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        config(httpPost);
        setPostParams(httpPost, params);
        return send(url, httpPost, ENCODE);
    }

    public static JSONObject postAndBodyAsJson(String url, Map<String, Object> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        config(httpPost);
        setPostParams(httpPost, params);
        String body = send(url, httpPost, ENCODE);
        return parseToJson(body);
    }

    /**
     * GET请求URL获取内容
     * 
     * @param url
     * @return
     */
    public static String get(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        config(httpGet);
        return send(url, httpGet, ENCODE);
    }

    public static String getAndBodyAsJson(String url, Map<String, Object> params) throws IOException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);

        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);

        HttpGet httpGet = new HttpGet(ub.build());

        httpGet.setHeader("Accept", "application/json");
        config(httpGet);
        String body = send(url, httpGet, ENCODE);
        return body;
    }
    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
        }

        return pairs;
    }
    public static JSONObject getAndBodyAsJson(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        config(httpGet);
        String body = send(url, httpGet, ENCODE);
        return parseToJson(body);
    }
    

    private static JSONObject parseToJson(String body){
        return JSON.parseObject(body);
    }

    private static <T extends HttpRequestBase> String send(String url, T httpMethod, String encode) throws IOException{
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient(url).execute(httpMethod,
                    HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, encode);
            EntityUtils.consume(entity);
            return result;
        } catch (IOException e) {
           throw e;
        } finally {
            try {
                if (response != null){
                    response.close();
                }
            } catch (IOException e) {
                //ignore
            }
        }
    }
    public static String httpPostWithJsonAndHeader(String url, String json, Map<String, String> headsMap) {
        String result = "";

        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        //头
        if (headsMap != null && !headsMap.isEmpty()) {
            headsMap.forEach((key, value) -> {
                httpPost.addHeader(key, value);
            });
        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpPost)) {

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 从响应模型中获取响应实体
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    result = EntityUtils.toString(responseEntity);
                }

            } else {
                return null;
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
    }
}