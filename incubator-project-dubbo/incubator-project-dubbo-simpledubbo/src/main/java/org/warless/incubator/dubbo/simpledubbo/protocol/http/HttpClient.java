package org.warless.incubator.dubbo.simpledubbo.protocol.http;


import org.apache.commons.io.IOUtils;
import org.warless.incubator.dubbo.simpledubbo.framework.Invocation;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author : fetaxyu
 * @date : 2019-09-16
 */
public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {
        try {
            URL url = new URL("http", hostname, port, "/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            OutputStream out = connection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();
            return IOUtils.toString(connection.getInputStream(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
