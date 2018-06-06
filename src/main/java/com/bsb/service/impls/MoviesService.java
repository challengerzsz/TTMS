package com.bsb.service.impls;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bsb.common.ServerResponse;
import com.bsb.dao.IMoviesMapper;
import com.bsb.pojo.Movie;
import com.bsb.service.IMoviesService;
import com.bsb.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    private IMoviesMapper moviesMapper;

    @Override
    public ServerResponse<String> initMovies() {

        String moviesJson = HttpClientUtil.getMainMovie();

//        logger.info(motviesJson);

        JSONObject jsonObject = JSONObject.parseObject(moviesJson);
//        logger.info("test here");
        String data = jsonObject.getString("data");
//        logger.info(data);
        jsonObject = JSON.parseObject(data);
        String moviesData = jsonObject.getString("movies");
//        parse jsonArray to List
        List<Movie> movies = JSONObject.parseArray(moviesData, Movie.class);

        int resultCount = moviesMapper.insertMovies(movies);

        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("初始化失败");
        }

        return ServerResponse.createBySuccessMsg("初始化成功");
    }

    @Override
    public ServerResponse<List<Movie>> getBoxOffice() {
        List<Movie> orderedMovies = moviesMapper.getBoxOffice();

        if (orderedMovies.size() == 0) {
            return ServerResponse.createByErrorMsg("获取票房失败");
        }

        return ServerResponse.createBySuccess("获取票房成功", orderedMovies);
    }

    @Override
    public ServerResponse<Movie> getMovieInfo(int id) {
        Movie movie = moviesMapper.getMovieInfo(id);

        if (movie == null) {
            return ServerResponse.createByErrorMsg("获取影片内容失败");
        }

        return ServerResponse.createBySuccess("获取影片内容成功", movie);
    }

    @Override
    public ServerResponse<List<Movie>> getUnSelectedMovies() {
        List<Movie> movies = moviesMapper.getUnSelectedMovies();

        if (movies.size() == 0) {
            return ServerResponse.createByErrorMsg("获取未添加影片失败");
        }

        return ServerResponse.createBySuccess("获取未添加影片成功" , movies);
    }
}