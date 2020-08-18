package com.adscanal.sdk.proxy;

import com.adscanal.sdk.common.AdTestUtils;
import com.adscanal.sdk.dto.LiveOffer;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

public class SimpleProxy {
    private static final Logger logger = LoggerFactory.getLogger(SimpleProxy.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger tracklogger = LoggerFactory.getLogger("track");


    public static final String username = "lum-customer-hl_97bee780-zone-static_res";
    public static final String password = "gwh05xf366u6";
    public static final int port = 22225;
    public static final String user_agent =
            "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";
    public static String session_id = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
    public CloseableHttpClient client;

    public SimpleProxy(String country) {
        String login = username + (country != null ? "-country-" + country : "")
                + "-session-" + session_id;

        HttpHost super_proxy = new HttpHost("zproxy.lum-superproxy.io", port);

        CredentialsProvider cred_provider = new BasicCredentialsProvider();
        cred_provider.setCredentials(new AuthScope(super_proxy),
                new UsernamePasswordCredentials(login, password));

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(200);

        client = HttpClients.custom()
                .setConnectionManager(cm)
                .setProxy(super_proxy)
                .setDefaultCredentialsProvider(cred_provider)
                .setRedirectStrategy(new RedirectStrategy() {
                    @Override
                    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                        return false;
                    }

                    @Override
                    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
                        return null;
                    }
                })
                .build();


    }

    public String request(String ua, String url, LiveOffer offer) throws IOException {
        tracklogger.warn(offer.getOfferId() + ":" + url);
        url = AdTestUtils.urlEncode(url);
        HttpGet request = new HttpGet(url);
        request.setHeader("User-Agent", ua);
        CloseableHttpResponse response = client.execute(request);
        if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
            String location = response.getHeaders("Location")[0].toString().substring(10).trim();
            request(ua, location, offer);
        }
        return EntityUtils.toString(response.getEntity());

    }

    public void close() throws IOException {
        client.close();
    }

}

