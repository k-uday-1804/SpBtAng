package com.AvenJavaPractice.movieservice.imdb.service;

import com.AvenJavaPractice.movieservice.imdb.model.Movie;
import com.AvenJavaPractice.movieservice.imdb.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;


    //CRUD operations
    public Movie create(Movie movie) {
        if(movie ==null){
            throw new RuntimeException("Invalid Movie");
        }
        return movieRepository.save(movie);
    }
    public Movie read(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie Not Found"));


    }
    public void update(Long id, Movie update){
        if(update == null || id == null){
            throw new RuntimeException("Invalid Error");
        }
        if(movieRepository.existsById(id)){
            Movie movie = movieRepository.getReferenceById(id);
            movie.setName(update.getName());
            movie.setDirector(update.getDirector());
            movie.setActors(update.getActors());
            movieRepository.save(movie);
        } else {
            throw new RuntimeException("Movie Not Found");

        }
    }
    public void delete(Long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Movie Not Found");

        }
    }

}
