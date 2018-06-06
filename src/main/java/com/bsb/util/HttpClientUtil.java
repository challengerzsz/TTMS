package com.bsb.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static String getMainMovie() {

        String moviesJson = null;

        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36");
            CloseableHttpResponse response = httpClient.execute(httpGet);


            HttpEntity entity = response.getEntity();

            if (entity != null) {
                moviesJson = EntityUtils.toString(entity);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return moviesJson;
    }

    public static void main(String[] args) {
        HttpClientUtil.getMainMovie();
    }
}
