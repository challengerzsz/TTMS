package com.bsb.controller;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Movie;
import com.bsb.service.IMoviesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/movies/")
public class MoviesController {

    @Autowired
    private IMoviesService moviesService;

    @GetMapping("initMovies")
    public ServerResponse<String> initMovies() {
        return moviesService.initMovies();
    }

    @GetMapping("unselected")
    public ServerResponse<List<Movie>> getUnSelectedMovies() {
        return moviesService.getUnSelectedMovies();
    }

    @GetMapping("{id}")
    public ServerResponse<Movie> getMovieInfo(@PathVariable("id") int id) {
        return moviesService.getMovieInfo(id);
    }

    @GetMapping("/boxOffice")
    public ServerResponse<List<Movie>> getBoxOffice() {
        return moviesService.getBoxOffice();
    }

}
