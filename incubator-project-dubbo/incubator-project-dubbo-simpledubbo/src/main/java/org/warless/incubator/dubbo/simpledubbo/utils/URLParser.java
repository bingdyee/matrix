package org.warless.incubator.dubbo.simpledubbo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

public class URLParser {

    public static String unquote(String url) {
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static Map<String, Object> urlparse() {
        return null;
    }

}
