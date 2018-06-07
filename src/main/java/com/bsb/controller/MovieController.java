package com.bsb.controller;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Movie;
import com.bsb.service.IMoviesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private IMoviesService moviesService;

    @PostMapping("/initMovies")
    public ServerResponse<String> initMovies() {
        return moviesService.initMovies();
    }

    @GetMapping("/unselected")
    public ServerResponse<List<Movie>> getUnSelectedMovies() {
        return moviesService.getUnSelectedMovies();
    }

    @GetMapping("/{id}")
    public ServerResponse<Movie> getMovieInfo(@PathVariable("id") String id) {
        return moviesService.getMovieInfo(id);
    }

    @GetMapping("/boxOffice")
    public ServerResponse<List<Movie>> getBoxOffice() {
        return moviesService.getBoxOffice();
    }

    @GetMapping("/selected")
    public ServerResponse<List<Movie>> getSelected() {
        return moviesService.getSelected();
    }

    @PostMapping("/select")
    public ServerResponse<String> selectMovies(@RequestBody HashMap<String,ArrayList<Integer>> moviesIdJson) {

        if (moviesIdJson == null) {
            return ServerResponse.createByErrorMsg("选择添加电影为空");
        }

        return moviesService.selectMovies(moviesIdJson);
    }

    @PostMapping("/{id}")
    public ServerResponse<String> deleteSelectedMovie(@PathVariable("id") Integer movieId) {
        if (movieId == null) {
            return ServerResponse.createByErrorMsg("传入参数为空");
        }

        return moviesService.deleteSelectedMovie(movieId);
    }


    @PostMapping("/update")
    public ServerResponse<Movie> updateSelectedMovie(Movie updateMovie) {
        if (updateMovie == null) {
            return ServerResponse.createByErrorMsg("传入参数为空");
        }

        return moviesService.updateSelectedMovie(updateMovie);
    }
}
