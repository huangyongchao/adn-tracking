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

/**
 * @author huangyongchao
 */
public class Collecter {
    public static final String rootPath = "/Volumes/FrankSSD/deviceid/devid";
    public static final String deviceidlog = "/Volumes/FrankSSD/";
    private static BufferedWriter writer = null;

    public static final Map<String, Collection<File>> GEO_FILES = Maps.newHashMap();

    public static final Set<String> ACTI_GEOS = Sets.newHashSet("VNM");
    public static final List<String> ACTI_OS = Lists.newArrayList("ios");
    public static final String NEWL = "\r\n";
    public static final String IOS = "ios";
    public static final String ANDROID = "android";
    public static Path uapath = Paths.get("/Users/huangyongchao/newprj/src/main/java/com/adscanal/sdk/datafile/ua");
    public static Map<String, List<String>> GEO_UA = Maps.newHashMap();
    static {
        ACTI_GEOS.forEach(geo -> {
            GEO_FILES.put(geo + IOS, new ConcurrentSkipListSet<>());
            GEO_FILES.put(geo + ANDROID, new ConcurrentSkipListSet<>());

        });
    }

    public static void initGua() {
        try {
            Files.lines(uapath).forEach(ua -> {
                String[] uary = ua.split("\\|");

                if (!GEO_UA.containsKey(uary[0])) {
                    GEO_UA.put(uary[0], Lists.newArrayList());
                }else{
                    if(ua.indexOf("1|")>0){
                        if(ua.indexOf("Phone")>0){
                            GEO_UA.get(uary[0]).add(uary[1]);
                        }
                    }else{
                        GEO_UA.get(uary[0]).add(uary[1]);

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
            v.forEach(file -> {
                ACTI_OS.forEach(os -> {
                    if (geoos.endsWith(os)) {
                        try {

                            if (writer == null) {
                                File wfile = new File(deviceidlog + geoos + ".log");
                                if (!wfile.exists()) {
                                    wfile.createNewFile();
                                }
                                wfile.setWritable(true);
                                writer = Files.newBufferedWriter(wfile.toPath());
                            }

                            Files.lines(file.toPath()).forEach(id -> {
                                try {
                                    writer.write("" + id + NEWL);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            });
        });
    }

    public static void main(String[] args) {
        initFilePath();
    }
}
