package com.ebdz.testing.movies.data;

import com.ebdz.testing.movies.model.Genre;
import com.ebdz.testing.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryImpl implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

        jdbcTemplate.update("insert into movies (name, minutes, genre, director) values (?,?,?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());

    }

    @Override
    public Movie findByName(String name) {
        Object[] args = {name};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE name = ?", args, movieMapper);
    }

    private static RowMapper<Movie> movieMapper = (resultSet, i) ->
            new Movie(
                resultSet.getInt("Id"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")),
                resultSet.getString("director")
    );
}
