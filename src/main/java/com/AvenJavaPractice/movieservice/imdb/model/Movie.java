package com.AvenJavaPractice.movieservice.imdb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String director;
    @ElementCollection
    private List<String> actors = new ArrayList<>();

}
