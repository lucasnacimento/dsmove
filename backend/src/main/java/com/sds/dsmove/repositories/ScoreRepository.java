package com.sds.dsmove.repositories;

import com.sds.dsmove.entities.Score;
import com.sds.dsmove.entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
