package com.ebdz.testing.movies.data;

import com.ebdz.testing.movies.model.Genre;
import com.ebdz.testing.movies.model.Movie;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.locks.StampedLock;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    DriverManagerDataSource dataSource;
    private MovieRepository movieRepository;

    @Before
    public void setUp() throws Exception {
         dataSource = new DriverManagerDataSource(
                "jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepository = new MovieRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1,"Dark Knight",152,Genre.ACTION,"director"),
                new Movie(2,"Memento",113,Genre.THRILLER,"director"),
                new Movie(3,"Matrix",136, Genre.ACTION,"director")
        )));
    }

    @Test
    public void load_movie_by_id() {

        Movie movie = movieRepository.findById(2);

        assertThat(movie, is(new Movie(2,"Memento",113,Genre.THRILLER,"director")));

    }

    @Test
    public void find_movie_by_name() {

        Movie movie = movieRepository.findByName("Memento");

        assertThat(movie, is(new Movie(2,"Memento",113,Genre.THRILLER,"director")));

    }

    @Test
    public void insert_a_movie() {

        Movie movie = new Movie("Super 8",112,Genre.THRILLER,"director");

        movieRepository.saveOrUpdate(movie);

        Movie movieFromDB =  movieRepository.findById(4);

        assertThat(movieFromDB, is(new Movie(4,"Super 8",112,Genre.THRILLER,"director")));

    }



    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}