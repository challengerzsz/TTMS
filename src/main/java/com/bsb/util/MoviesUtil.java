package com.bsb.util;

public class MoviesUtil {

    public static String execute() {

        String url = "http://m.maoyan.com/movie/list.json";
        return NetWorkUtil.get(url);

    }

    public static void main(String[] args) {
        execute();
    }
}
