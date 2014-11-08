package pl.java.scalatech;

import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.scalatech.config.RepositoryConfig;
import pl.java.scalatech.domain.Country;
import pl.java.scalatech.repository.country.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RepositoryConfig.class })
@Transactional
public class RepositoryTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Autowired
    private CountryRepository countryRepository;

    @Before
    public void init() {
        countryRepository.deleteAll();
    }

    @Test
    public void shouldBootstrapTest() {
        Assertions.assertThat(countryRepository.count()).isZero();
    }

    @Test
    public void shouldAddCountry() {
        Country country = Country.builder().name("Poland").build();
        countryRepository.save(country);
        Assertions.assertThat(countryRepository.count()).isEqualTo(1l);
    }

    @Test
    public void shouldFindCountry() {
        Country country = Country.builder().name("Poland").build();
        countryRepository.save(country);
        List<Country> result = countryRepository.findAll();
        Assertions.assertThat(result).contains(country);
    }

    @Test
    public void shouldTryFindCountryAndThrowException() {
        Country country = Country.builder().name("Poland").build();
        countryRepository.save(country);
      
        Country result = countryRepository.findOne(2l);
        Assertions.assertThat(result).isEqualTo(country);
    }

    @Test
    public void shouldTryFindCountryByNameAndThrowException() {
        Country country = Country.builder().name("Poland").build();
        countryRepository.save(country);
     
        Country result = countryRepository.findByName("USA");
        Assertions.assertThat(result).isNull();
    }

    @Test
    public void shouldFindCountryByName() {
        Country country = Country.builder().name("Poland").build();
        countryRepository.save(country);
        Country result = countryRepository.findByName("Poland");
        Assertions.assertThat(result).isEqualTo(country);
    }
    @Test
    public void shouldRemove() {
        Country country = Country.builder().name("Poland").build();
        countryRepository.save(country);
        Assertions.assertThat(countryRepository.count()).isEqualTo(1l);
        countryRepository.delete(country);
        Assertions.assertThat(countryRepository.count()).isEqualTo(0);
    }
}
