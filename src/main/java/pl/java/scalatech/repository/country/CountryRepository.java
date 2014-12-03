package pl.java.scalatech.repository.country;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{


    Country findByName(String name);
    
    Optional<Country> findByCode(String code);
}
