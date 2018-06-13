package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Movie;
import com.bsb.pojo.UpdateMovie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IMoviesService {

    ServerResponse<String> initMovies();

    ServerResponse<List<Movie>> getBoxOffice();

    ServerResponse<Movie> getMovieInfo(String id);

    ServerResponse<List<Movie>> getUnSelectedMovies();

    ServerResponse<List<Movie>> getSelected();

    ServerResponse<String> selectMovies(HashMap<String,ArrayList<Integer>> moviesIdJson);

    ServerResponse<String> deleteSelectedMovie(Map<String, String> deleteMovieJson);

    ServerResponse<String> updateSelectedMovie(Map<String, List<UpdateMovie>> updateMovieJson);
}