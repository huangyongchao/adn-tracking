package com.adscanal.sdk.datafile;

import com.adscanal.sdk.common.AppConstant;
import com.google.common.collect.Maps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author huangyongchao
 */
public class FileCollect {
    public static final String rootPath = "/Volumes/FrankSSD/deviceid/devid";
    public static final String deviceidlog = "/Volumes/FrankSSD/";
    private static BufferedWriter writer = null;


    public static final Map<String, Collection<File>> GEO_FILES = Maps.newHashMap();

    static {
        AppConstant.ACTI_GEOS.forEach(geo -> {
            GEO_FILES.put(geo + AppConstant.IOS, new ConcurrentSkipListSet<>());
            GEO_FILES.put(geo + AppConstant.ANDROID, new ConcurrentSkipListSet<>());

        });
    }

    public static void initFilePath() {

        try {
            java.nio.file.Files.walkFileTree(new File(rootPath).toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    AppConstant.ACTI_GEOS.forEach(geo -> {
                        String path = file.toString();
                        if (path.indexOf(geo.toLowerCase()) > 0) {
                            AppConstant.ACTI_OS.forEach(os -> {
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
                AppConstant.ACTI_OS.forEach(os -> {
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
                                    writer.write("" + id + AppConstant.NEWL);
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
