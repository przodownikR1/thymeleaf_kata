package pl.java.scalatech.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Fight extends PKEntity {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Boxer winner;
    @ManyToOne
    private Boxer loser;

    private Date fightDate;

}
