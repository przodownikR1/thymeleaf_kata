package pl.java.scalatech.service.country;

import java.util.List;

import pl.java.scalatech.domain.Country;

public interface CountryService {
    List<Country> findAll();

    Country findOne(Long id);

    void delete(Country country);

    Country save(Country country);

    Country findByCode(String code);

    Country findByName(String name);

   /* Country saveWeb(Country country);*/
}
