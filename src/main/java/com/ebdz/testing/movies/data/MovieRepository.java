package com.ebdz.testing.movies.data;

import com.ebdz.testing.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);

    Movie findByName(String name);
}
