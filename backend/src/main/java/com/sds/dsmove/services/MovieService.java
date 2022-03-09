package com.sds.dsmove.services;

import com.sds.dsmove.dtos.MovieDto;
import com.sds.dsmove.entities.Movie;
import com.sds.dsmove.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    
    @Transactional(readOnly = true)
    public Page<MovieDto> findAll(Pageable pageable) {
        Page<Movie> result = repository.findAll(pageable);
        Page<MovieDto> resultDto = result.map(x -> new MovieDto(x));
        return resultDto;
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id) {
        Movie result = repository.getById(id);
        MovieDto resultDto = new MovieDto(result);
        return resultDto;
    }

}
