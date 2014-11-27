package pl.java.scalatech.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Fight extends PKEntity {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name="winnerId")
    private Boxer winner;
    
    @ManyToOne
    @JoinColumn(name="loserId")
    private Boxer loser;

    private Date fightDate;

    private int roundCount;
    
    
    @ManyToOne
    @JoinColumn(name="placeId")
    private Place place;    
}
