package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Movie;

import java.util.List;

public interface IMoviesService {

    ServerResponse<String> initMovies();

    ServerResponse<List<Movie>> getBoxOffice();

    ServerResponse<Movie> getMovieInfo(int id);

    ServerResponse<List<Movie>> getUnSelectedMovies();


}

