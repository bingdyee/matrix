package org.warless.incubator.simplefeign.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yubb
 * @date 2019-08-06
 */
public class CommonUtils {

    private static final String FILE_SEPARATOR = File.separator;

    public static boolean isEmpty(byte[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isNotEmpty(byte[] arr) {
        return arr != null && arr.length != 0;
    }

    public static boolean isEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }

    public static boolean isNotEmpty(Object[] arr) {
        return arr != null && arr.length != 0;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static List<String> listFiles(String path) {
        File file = new File(path);
        List<String> fileList = new ArrayList<>();
        if (file.isFile()) {
            fileList.add(path);
        } else {
            File[] files = file.listFiles();
            if (isNotEmpty(files)) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        fileList.addAll(listFiles(path + FILE_SEPARATOR + f.getName()));
                    } else {
                        fileList.add(path + FILE_SEPARATOR + f.getName());
                    }
                }
            }
        }
        return fileList;
    }

    public static void mkdirs(String path) {
        File destFile = new File(path);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
    }

    public static void copy(String src, String dest) {
        File file = new File(src);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest + File.separator + file.getName());
            byte[] buffer = new byte[2048];
            int len;
            while ((len =in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ignored) {}
        }
    }

    private static final double EARTH_RADIUS = 6378.137;

    private static double rad(double x) {
        return x * Math.PI / 180.;
    }

    /**
     * 北纬,东经: lat,lng
     *
     * @param from
     * @param to
     * @return
     */
    public static double getDistance(String from, String to) {
        String[] points = from.split(",");
        double lat1 = Double.parseDouble(points[0]);
        double lng1 = Double.parseDouble(points[1]);
        points = to.split(",");
        double lat2 = Double.parseDouble(points[0]);
        double lng2 = Double.parseDouble(points[1]);
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = Math.round(s * EARTH_RADIUS * 10000.) / 10000.;
        return s * 1000;
    }

    public static void main(String[] args) {
        System.err.println(getDistance("30.2809379046,120.1369248769", "30.2799140479,120.1399718664"));
    }

}