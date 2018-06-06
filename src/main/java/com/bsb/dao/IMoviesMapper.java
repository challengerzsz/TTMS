package com.bsb.dao;

import com.bsb.pojo.Movie;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IMoviesMapper {

    int insertMovies(List<Movie> movies);

    @Select("SELECT * FROM movies_table WHERE status = 0 limit 0, 2")
    List<Movie> getUnSelectedMovies();

    @Select("SELECT * FROM movies_table order by sc limit 0, 2")
    List<Movie> getBoxOffice();

    @Select("SELECT * FROM movies_table WHERE id = #{id}")
    Movie getMovieInfo(int id);
}
