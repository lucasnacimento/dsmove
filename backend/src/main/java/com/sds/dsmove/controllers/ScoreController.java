package com.sds.dsmove.controllers;

import com.sds.dsmove.dtos.MovieDto;
import com.sds.dsmove.dtos.ScoreDto;
import com.sds.dsmove.services.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;
    
    @PutMapping
    public MovieDto save(@RequestBody ScoreDto dto) {
        MovieDto resultDto = service.saveScore(dto);
        return resultDto;
    }
}
