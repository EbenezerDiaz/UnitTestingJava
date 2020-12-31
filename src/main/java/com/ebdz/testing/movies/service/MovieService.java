package com.ebdz.testing.movies.service;

import com.ebdz.testing.movies.data.MovieRepository;
import com.ebdz.testing.movies.model.Genre;
import com.ebdz.testing.movies.model.Movie;

import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(int length) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());

    }

    public Collection<Movie> findMovieByName(String name){
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByDirector(String director) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(director.toLowerCase())).collect(Collectors.toList());

    }

    public Collection<Movie> findMovieByTemplate(Movie template) {

        Collection<Movie> movies = movieRepository.findAll();

        if (template.getId() != null){
            movies = movies.stream().filter(movie -> movie.getId() == template.getId()).collect(Collectors.toList());
        }

        if(template.getName()!=null ){
            movies = movies.stream()
                    .filter(movie -> movie.getName().toLowerCase().contains(
                            template.getName().toLowerCase())).collect(Collectors.toList());
        }

        if(template.getMinutes() != null){
            movies = movies.stream()
                    .filter(movie -> movie.getMinutes() <= template.getMinutes()).collect(Collectors.toList());
        }

        if(template.getGenre()!=null){
            movies = movies.stream()
                    .filter(movie -> movie.getGenre() == template.getGenre()).collect(Collectors.toList());
        }

        if(template.getDirector()!=null ){
            movies = movies.stream()
                    .filter(movie -> movie.getDirector().toLowerCase().contains(
                            template.getDirector().toLowerCase())).collect(Collectors.toList());
        }

        return movies;
    }
}
