package pl.java.scalatech.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Boxer extends PKEntity {

    private static final long serialVersionUID = 2833077788091842348L;

    private String name;

    private String nick;
    @Enumerated
    private Division division;

    @Enumerated
    private Stance stance;

    @ManyToOne
    private Country country;

    private int lost;
    private int won;
    private int draw;

}
