package com.sds.dsmove.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ScoreDto {

    private Long movieId;

    private String email;

    private Double score;
    
}
