package com.bsb.service.impls;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bsb.common.ServerResponse;
import com.bsb.mapper.IMoviesMapper;
import com.bsb.pojo.Movie;
import com.bsb.pojo.UpdateMovie;
import com.bsb.service.IMoviesService;
import com.bsb.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    private IMoviesMapper moviesMapper;

    @Override
    public ServerResponse<String> initMovies() {

        String moviesJson = HttpClientUtil.getMainMovie();


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
    public ServerResponse<Movie> getMovieInfo(String id) {
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

    @Override
    public ServerResponse<List<Movie>> getSelected() {
        List<Movie> movies = moviesMapper.getSelected();

        if (movies.size() == 0) {
            return ServerResponse.createByErrorMsg("未添加影片");
        }

        return ServerResponse.createBySuccess("获取影片成功" , movies);
    }

    @Override
    public ServerResponse<String> selectMovies(HashMap<String,ArrayList<Integer>> moviesIdJson) {

        ArrayList<Integer> moviesId = moviesIdJson.get("moviesId");

        int resultCount = 0;
        for (Integer movieId : moviesId) {
            resultCount = moviesMapper.selectMovie(movieId);
            if (resultCount == 0) {
                return ServerResponse.createByErrorMsg("添加影片失败");
            }
        }

        return ServerResponse.createBySuccessMsg("添加影片成功");
    }

    @Override
    public ServerResponse<String> deleteSelectedMovie(Map<String, String> deleteMovieJson) {

        String deleteMovie = deleteMovieJson.get("id");
        if (deleteMovie == null) {
            return ServerResponse.createByErrorMsg("待删除的电影id为空，删除失败");
        }

        int resultCount = moviesMapper.deleteSelectedMovie(deleteMovie);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("电影院没有上映该电影");
        }

        return ServerResponse.createBySuccessMsg("删除影片成功");
    }

    @Override
    public ServerResponse<String> updateSelectedMovie(Map<String, List<UpdateMovie>> updateMovieJson) {

        List<UpdateMovie> updateMovies = updateMovieJson.get("updateMovieIds");

        int resultCount  = moviesMapper.updateSelectedMovie(updateMovies);

        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("更新影片信息失败");
        }

        return ServerResponse.createBySuccess("更新影片信息成功");
    }
}