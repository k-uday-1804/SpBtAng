package com.AvenJavaPractice.movieservice.imdb.repo;

import com.AvenJavaPractice.movieservice.imdb.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
