package pl.java.scalatech.config;

import javax.annotation.PostConstruct;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.java.scalatech.domain.Boxer;
import pl.java.scalatech.domain.Country;
import pl.java.scalatech.domain.Division;
import pl.java.scalatech.domain.Stance;
import pl.java.scalatech.service.boxer.BoxerService;
import pl.java.scalatech.service.country.CountryService;
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "pl.java.scalatech.service" }, useDefaultFilters = false, includeFilters = { @Filter(Service.class) })
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class ServiceConfig {

    
    @Autowired
    private  CountryService countryService;
    @Autowired
    private  BoxerService boxerService;
    
    @PostConstruct
    public void init(){
        System.err.println("ddddddddddddddd");
        countryService.save(Country.builder().name("Poland").code("PL").build());
        countryService.save(Country.builder().name("Philippines").code("PHI").build());
        countryService.save(Country.builder().name("Russia ").code("RUS").build());
        countryService.save(Country.builder().name("Argentina").code("ARG").build());
        countryService.save(Country.builder().name("Australia").code("AUS").build());
        countryService.save(Country.builder().name("China").code("CHN").build());
        countryService.save(Country.builder().name("Cuba").code("CUB").build());
        countryService.save(Country.builder().name("Germany").code("GER").build());
        countryService.save(Country.builder().name("Italy").code("ITA").build());
        
        countryService.save(Country.builder().name("Jamaica").code("JAM").build());
        countryService.save(Country.builder().name("Kazakhstan").code("KAZ").build());
        countryService.save(Country.builder().name("Mexico").code("MEX").build());
        countryService.save(Country.builder().name("Nigeria").code("NGA").build());
        
        countryService.save(Country.builder().name("Romania").code("ROU").build());
        countryService.save(Country.builder().name("South Africa").code("RSA").build());
        countryService.save(Country.builder().name("Serbia").code("SRB").build());
        countryService.save(Country.builder().name("Ukraine").code("URK").build());
        countryService.save(Country.builder().name("United States").code("USA").build());
        countryService.save(Country.builder().name("Uzbekistan").code("UZB").build());
        
        boxerService.save(Boxer.builder().country(countryService.findByCode("PL")).division(Division.Heavyweight).name("Artur Szpilka").draw(0).lost(1).won(29).nick("Pin").stance(Stance.southpaw).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Heavyweight).name("Mike Tyson").draw(2).lost(3).won(45).nick("Iron Mike").stance(Stance.orthodox).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Light_Heavyweight).name("Roy Jones Jr").draw(2).lost(3).won(46).nick("jr").stance(Stance.orthodox).build());
        
        
        boxerService.save(Boxer.builder().country(countryService.findByCode("URK")).division(Division.Heavyweight).name("Wladimir Klitschko").draw(0).lost(3).won(63).nick("Dr Steelhammer").stance(Stance.orthodox).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("GER")).division(Division.Cruiserweight).name("Marco Huck").draw(1).lost(2).won(38).nick("Kapitan").stance(Stance.orthodox).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Light_Heavyweight).name("Adonis Stevenson").draw(0).lost(1).won(24).nick("SuperMan").stance(Stance.orthodox).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("GBR")).division(Division.Super_Middleweight).name("Carl Froch").draw(0).lost(2).won(33).nick("The Cobra").stance(Stance.orthodox).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("KAZ")).division(Division.Middleweight).name("Gennady Golovkin").draw(0).lost(0).won(31).nick("GGG").stance(Stance.orthodox).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("MEX")).division(Division.Lightweight).name("Saul Alvarez").draw(1).lost(1).won(44).nick("Canelo").stance(Stance.orthodox).build());
        boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Welterweight).name("Floyd Mayweather Jr").draw(1).lost(0).won(47).nick("Money / Pretty Boy").stance(Stance.orthodox).build());
        
    }
    
    
}
