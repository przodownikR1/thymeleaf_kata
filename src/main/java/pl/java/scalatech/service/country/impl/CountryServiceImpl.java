package pl.java.scalatech.service.country.impl;

import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.scalatech.domain.Country;
import pl.java.scalatech.repository.country.CountryRepository;
import pl.java.scalatech.service.country.CountryService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountryServiceImpl implements CountryService {
    private final @NonNull CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findOne(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    @Transactional
    public void delete(Country country) {
        countryRepository.delete(country);

    }

    @Override
    @Transactional
    public void save(Country country) {
        countryRepository.save(country);

    }

    @Override
    public Country findByCode(String code) {
        return countryRepository.findByCode(code);
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name);
    }
}
