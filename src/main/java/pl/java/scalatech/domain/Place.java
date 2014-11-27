package pl.java.scalatech.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Place extends PKEntity {

    private static final long serialVersionUID = -836783038319152972L;

    @Embedded
    private Location location;

    @ManyToOne
    private Country country;

    @NotNull
    @Size(min = 2, max = 50)
    @Pattern(regexp = ".+")
    @Column(name = "city", nullable = false, length = 50)
    private String city;
}
