package com.ebdz.testing.movies.service;

import com.ebdz.testing.movies.data.MovieRepository;
import com.ebdz.testing.movies.model.Genre;
import com.ebdz.testing.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "A", 152, Genre.ACTION),
                        new Movie(2, "B", 113, Genre.THRILLER),
                        new Movie(3, "C", 119, Genre.COMEDY),
                        new Movie(4, "D", 112, Genre.THRILLER),
                        new Movie(5, "B", 111, Genre.HORROR),
                        new Movie(6, "C", 103, Genre.COMEDY),
                        new Movie(7, "D", 136, Genre.ACTION),
                        new Movie(8, "E", 145, Genre.DRAMA)
                )
        );

        movieService = new MovieService(movieRepository);

    }

    @Test
    public void return_movies_by_length(){

        Collection<Movie> movies = movieService.findMovieByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3,6)));

    }

    @Test
    public void return_movies_by_genre(){

        Collection<Movie> movies = movieService.findMovieByLength(119);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @NotNull
    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}