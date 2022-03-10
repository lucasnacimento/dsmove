package com.sds.dsmove.services;

import com.sds.dsmove.dtos.MovieDto;
import com.sds.dsmove.dtos.ScoreDto;
import com.sds.dsmove.entities.Movie;
import com.sds.dsmove.entities.Score;
import com.sds.dsmove.entities.User;
import com.sds.dsmove.repositories.MovieRepository;
import com.sds.dsmove.repositories.ScoreRepository;
import com.sds.dsmove.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDto saveScore(ScoreDto dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double media = movie.getScores().stream().mapToDouble(Score::getValue).average().getAsDouble();

        movie.setScore(media);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        return new MovieDto(movie);
    }
    

}
