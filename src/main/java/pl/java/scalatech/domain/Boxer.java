package pl.java.scalatech.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.experimental.Builder;

@Data
@Builder
@Entity
public class Boxer extends PKEntity{
  private String name;
  private String nick;
  @Enumerated
  private Weight weight;
  @OneToOne
  private Country country;
  private int lost;
  private int win;
  private int draw;
  
}
