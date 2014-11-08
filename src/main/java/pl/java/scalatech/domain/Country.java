package pl.java.scalatech.domain;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Country extends PKEntity {

    private static final long serialVersionUID = 4734500867141934540L;
    private String name;

}
