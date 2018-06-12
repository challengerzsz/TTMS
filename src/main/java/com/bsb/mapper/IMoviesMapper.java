package com.bsb.mapper;

import com.bsb.pojo.Movie;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IMoviesMapper {

    int insertMovies(List<Movie> movies);

    @Select("SELECT * FROM movies_table WHERE status = 0 LIMIT 0, 8")
    List<Movie> getUnSelectedMovies();

    @Select("SELECT * FROM movies_table WHERE status = 1 ORDER BY sc DESC limit 0, 10")
    List<Movie> getBoxOffice();

    @Select("SELECT * FROM movies_table WHERE id = #{id}")
    Movie getMovieInfo(String id);

    @Select("SELECT * FROM movies_table WHERE status = 1 limit 0, 10")
    List<Movie> getSelected();

    @Update("UPDATE movies_table SET status = 1 WHERE id = #{movieId}")
    int selectMovie(Integer movieId);

    @Update("UPDATE movies_table SET status = 0 WHERE id = #{deleteMovieId} AND status = 1")
    int deleteSelectedMovie(String deleteMovieId);

    @Update("UPDATE movies_table SET imax = #{updateMovie.imax} WHERE id = #{updateMovie.id}")
    int updateSelectedMovie(Movie updateMovie);
}