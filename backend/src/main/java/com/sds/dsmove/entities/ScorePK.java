package com.sds.dsmove.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class ScorePK implements Serializable{

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
