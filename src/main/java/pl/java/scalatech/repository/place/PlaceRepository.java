package pl.java.scalatech.repository.place;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Place;

public interface PlaceRepository extends   JpaRepository<Place, Long>{

}
