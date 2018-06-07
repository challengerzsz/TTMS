package com.bsb.util;

import com.bsb.mapper.IMoviesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    @Autowired
    private static IMoviesMapper moviesMapper;

    public static int transferMovies() {
//        String moviesJson = HttpClientUtil.getMainMovie();
//
//        logger.info(moviesJson);
//
//        JSONObject jsonObject = JSONObject.parseObject(moviesJson);
//        logger.info("test here");
//        String data = jsonObject.getString("data");
//        logger.info(data);
//        jsonObject = JSON.parseObject(data);
//        String moviesData = jsonObject.getString("movies");
////        parse jsonArray to List
//        List<Movie> movies = JSONObject.parseArray(moviesData, Movie.class);
//
//        int resultCount = moviesMapper.insertMovies(movies);
//
//        if (resultCount == 0) {
//            return resultCount;
//        }
//
//        return resultCount;
        return 0;
    }

    public static void main(String[] args) {
        transferMovies();
//        logger.error(HttpClientUtil.getMainMovie());
    }
}