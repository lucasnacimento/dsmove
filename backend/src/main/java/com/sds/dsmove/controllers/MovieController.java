package com.sds.dsmove.controllers;

import com.sds.dsmove.dtos.MovieDto;
import com.sds.dsmove.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    
    @Autowired
    private MovieService service;

    @GetMapping
    public Page<MovieDto> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable(value = "id") Long id , Pageable pageable) {
        return service.findById(id);
    }

    

}
