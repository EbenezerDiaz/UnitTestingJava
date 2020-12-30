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
                        new Movie(1,"Dark Knight",152,Genre.ACTION,"director2"),
                        new Movie(2,"Memento",113,Genre.THRILLER,"director1"),
                        new Movie(3,"There's Something About Mary",119,Genre.COMEDY,"director2"),
                        new Movie(4,"Super 8",112,Genre.THRILLER,"director1"),
                        new Movie(5,"Scream",111,Genre.HORROR,"director2"),
                        new Movie(6,"Home Alone",103,Genre.COMEDY,"director1"),
                        new Movie(7,"Matrix",136,Genre.ACTION,"director2"),
                        new Movie(8,"Superman",140,Genre.ACTION,"director2")
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

    @Test
    public void return_movies_by_name(){

        Collection<Movie> movies = movieService.findMovieByName("suPEr");
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(4, 8)));
    }

    @Test
    public void return_movies_by_director(){

        Collection<Movie> movies = movieService.findMovieByDirector("Director1");
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 4, 6)));
    }

    @NotNull
    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}