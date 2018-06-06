package com.bsb.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class NetWorkUtil {

    public static String get(String url) {
        return post(url, null);
    }

    private static String post(String url, Map param) {

        HttpURLConnection connection = null;

        try {
            URL u = new URL(url);
            connection = (HttpURLConnection) u.openConnection();
            StringBuffer stringBuffer = null;

            if (param != null) {
                stringBuffer = new StringBuffer();

                connection.setDoInput(true);
                connection.setDoOutput(true);

                connection.setRequestMethod("POST");

                connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
                connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                connection.setRequestProperty("Cookie", "iuuid=F4364E7BAFEA0C2810E95B527F2F9333A849B8011E1D770622312E66AF271486; ci=42; v=3; JSESSIONID=a5wizstzqrh11fnr381n8aw2w");
                connection.setRequestProperty("Connection","keep-alive");
                connection.setRequestProperty("Host","m.maoyan.com");
                connection.setRequestProperty("Upgrade-Insecure-Requests","1");
                connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));


                Iterator iterator = param.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    stringBuffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }

                bufferedWriter.write(stringBuffer.deleteCharAt(stringBuffer.toString().length() - 1).toString());

                bufferedWriter.close();

                stringBuffer = null;
            }

            connection.connect();
            stringBuffer = new StringBuffer();

            int resultCode = connection.getResponseCode();

            BufferedReader bufferedReader = null;

            System.out.println(connection.getResponseMessage());
            System.out.println(connection.getRequestMethod());
//            System.out.println(connection.get);
            if (resultCode == 200) {

                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

                String str = null;
                stringBuffer = new StringBuffer();

                while ((str = bufferedReader.readLine()) != null) {
                    stringBuffer.append(str).append(System.getProperty("line.separator"));
                }

                bufferedReader.close();

                if (stringBuffer.toString().length() == 0) {
                    return null;
                }

                return stringBuffer.toString().substring(0,
                        stringBuffer.toString().length() - System.getProperty("line.separator").length());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
