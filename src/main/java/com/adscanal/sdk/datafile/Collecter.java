package com.adscanal.sdk.datafile;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
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
    public static final String rootPath = "/Volumes/FrankSSD/deviceid/devid2";
    public static final String deviceidlog = "/Volumes/FrankSSD/";
    private static BufferedWriter writer = null;

    public static final Map<String, Collection<File>> GEO_FILES = Maps.newHashMap();


    public static final String NEWL = "\r\n";
    public static final String IOS = "ios";
    public static final String ANDROID = "android";
    public static Path uapath = Paths.get("/opt/did/ua");
    public static Map<String, List<String>> OS_UA = Maps.newHashMap();

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
    public static final Set<String> ACTI_GEOS = Sets.newHashSet("IND");
    public static final List<String> ACTI_OS = Lists.newArrayList("android");

    static {
        ACTI_GEOS.forEach(geo -> {
            GEO_FILES.put(geo + IOS, new ConcurrentSkipListSet<>());
            GEO_FILES.put(geo + ANDROID, new ConcurrentSkipListSet<>());
        });
    }
    public static void main(String[] args) {


        initFilePath();
        //dist();
        System.out.println(1);


    }
}
