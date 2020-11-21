package com.adscanal.sdk.datafile;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

/**
 * @author huangyongchao
 */
public class Collecter {
    public static final String rootPath = "/Volumes/FrankSSD/deviceid/";
    public static final String deviceidlog = "/Volumes/FrankSSD/";
    private static BufferedWriter writer = null;

    public static final Map<String, Collection<File>> GEO_FILES = Maps.newHashMap();


    public static final String NEWL = "\r\n";
    public static final String IOS = "ios";
    public static final String ANDROID = "android";
    public static Path uapath = Paths.get("/opt/did/ua");
    public static Map<String, List<String>> OS_UA = Maps.newHashMap();
    public static Map<String, Map<String, List<String>>> GEO_OS_UA = Maps.newHashMap();
/*
    System.out.println(Files.lines(Paths.get(path)).count());
    System.out.println(Files.lines(Paths.get(path)).distinct().count());
    Files.write(Paths.get(path + ".dist"), Files.lines(Paths.get(path)).distinct().collect(Collectors.toList()));
*/

    public static void initGua() {
        try {
            Files.lines(uapath).forEach(ua -> {
                String[] uary = ua.split("\\|");

                if (!OS_UA.containsKey(uary[0])) {
                    OS_UA.put(uary[0], Lists.newArrayList());
                } else {
                    if (ua.startsWith("1|")) {
                        if (ua.indexOf("Phone") > 0 && ua.indexOf("13_") > 0) {
                            OS_UA.get(uary[0]).add(uary[1]);
                        }
                    } else {
                        if (ua.indexOf("Android 9") > 0 || ua.indexOf("Android 10") > 0 || ua.indexOf("Android 11") > 0) {
                            OS_UA.get(uary[0]).add(uary[1]);
                        }

                    }
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void initFilePath() {

        try {
            java.nio.file.Files.walkFileTree(new File(rootPath).toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    ACTI_GEOS.forEach(geo -> {
                        String path = file.toString();
                        if (path.indexOf(geo.toLowerCase()) > 0) {
                            ACTI_OS.forEach(os -> {
                                if (path.indexOf(os.toLowerCase()) >= 0) {
                                    GEO_FILES.get(geo + os).add(file.toFile());
                                }
                            });
                        }
                    });

                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GEO_FILES.forEach((geoos, v) -> {

            File wfile = new File(deviceidlog + geoos + ".log");
            if (!wfile.exists()) {
                try {
                    wfile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                final BufferedWriter writer = Files.newBufferedWriter(wfile.toPath());

                v.forEach(subfile -> {
                    try {
                        System.out.println(geoos + ":" + subfile);
                        Files.lines(Paths.get(subfile.getPath())).distinct().forEach(dev -> {
                            try {
                                writer.write(dev);
                                writer.newLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }

    public static void dist(){
        ACTI_GEOS.forEach(geo -> {
            ACTI_OS.forEach(os -> {

                try {
                    String file = "/Volumes/FrankSSD/" + geo + os + ".log";
                    String file1 = file + ".dist";

                    try {
                        Files.write(Paths.get(file1), Files.lines(Paths.get(file)).distinct().collect(Collectors.toList()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        });
    }

    public static final Set<String> ACTI_GEOS = Sets.newHashSet("AUS");
    public static final List<String> ACTI_OS = Lists.newArrayList("ios");

    static {
        ACTI_GEOS.forEach(geo -> {
            GEO_FILES.put(geo + IOS, new ConcurrentSkipListSet<>());
            GEO_FILES.put(geo + ANDROID, new ConcurrentSkipListSet<>());
        });
    }

    public static void ua() {


        try {
            File file = new File("/Volumes/FrankSSD/appsok.log");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = ""; // 每一行的内容
            int i = 1;
            Path p = Paths.get("/Volumes/FrankSSD/appsokdist.log");
            if (!Files.exists(p)) {
                Files.createFile(p);
            }
            final BufferedWriter writer = Files.newBufferedWriter(p);
            Set<String> uset = Sets.newConcurrentHashSet();
            while ((line = br.readLine()) != null) {
                String mdg = MD5Encode.md5(line, null);
       /*         if (line.indexOf("|2|") > 0) {
                    if (line.indexOf("Android 9") > 0 || line.indexOf("Android 10") > 0 || line.indexOf("Android 11") > 0 || line.indexOf("Android 12") > 0) {
                        writer.write(line);
                    }
                } else {
                    if (line.indexOf("iPhone OS 14") > 0 || line.indexOf("iPhone OS 13") > 0) {
                        writer.write(line);
                    }
                }*/
                if (!uset.contains(mdg)) {
                    uset.add(mdg);
                    writer.write(line);
                    writer.newLine();
                    i++;
                }
            }

            System.out.println(i);
            reader.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initUANEW() {
        try {
            File file = new File("/opt/did/appsokdist.log");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = ""; // 每一行的内容
            int i = 1;
            Set<String> uset = Sets.newConcurrentHashSet();
            while ((line = br.readLine()) != null) {
                String[] as = line.split("\\|");
                if (as == null || as.length != 4) {
                    continue;
                }
                String geo = as[0];
                String os = as[1];
                String app = as[2];
                String uaa = as[3];
                if (!GEO_OS_UA.containsKey(geo)) {
                    GEO_OS_UA.put(geo, Maps.newConcurrentMap());
                }
                if (!GEO_OS_UA.get(geo).containsKey(os)) {
                    GEO_OS_UA.get(geo).put(os, Lists.newArrayList());
                }
                GEO_OS_UA.get(geo).get(os).add(uaa);

            }
            GEO_OS_UA.forEach((k, v) -> {
                v.forEach((kk, vv) -> {
                    if (vv.size() < 20) {
                        System.out.println("UA信息较少的地区和系统" + k + kk);
                    }
                });
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        initUANEW();
        //dist();
        System.out.println(1);


    }
}
