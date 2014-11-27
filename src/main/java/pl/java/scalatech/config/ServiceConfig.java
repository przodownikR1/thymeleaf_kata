package pl.java.scalatech.config;

import java.util.Date;

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
import pl.java.scalatech.domain.Fight;
import pl.java.scalatech.domain.Location;
import pl.java.scalatech.domain.Place;
import pl.java.scalatech.domain.Stance;
import pl.java.scalatech.service.boxer.BoxerService;
import pl.java.scalatech.service.country.CountryService;
import pl.java.scalatech.service.fight.FightService;
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
    
    @Autowired
    private FightService fightService;
    
    @PostConstruct
    public void init(){
       
        Country poland = countryService.save(Country.builder().name("Poland").code("PL").build());
        Country philippines = countryService.save(Country.builder().name("Philippines").code("PHI").build());
        Country russia = countryService.save(Country.builder().name("Russia ").code("RUS").build());
        Country argentina = countryService.save(Country.builder().name("Argentina").code("ARG").build());
        Country australia = countryService.save(Country.builder().name("Australia").code("AUS").build());
        Country china = countryService.save(Country.builder().name("China").code("CHN").build());
        Country cuba = countryService.save(Country.builder().name("Cuba").code("CUB").build());
        Country germany = countryService.save(Country.builder().name("Germany").code("GER").build());
        Country italy = countryService.save(Country.builder().name("Italy").code("ITA").build());
        
        Country jamaica = countryService.save(Country.builder().name("Jamaica").code("JAM").build());
        Country kazakhstan = countryService.save(Country.builder().name("Kazakhstan").code("KAZ").build());
        Country mexico = countryService.save(Country.builder().name("Mexico").code("MEX").build());
        Country nigeria = countryService.save(Country.builder().name("Nigeria").code("NGA").build());
        
        Country romania = countryService.save(Country.builder().name("Romania").code("ROU").build());
        Country sAfrica = countryService.save(Country.builder().name("South Africa").code("RSA").build());
        Country serbia = countryService.save(Country.builder().name("Serbia").code("SRB").build());
        Country ukraine = countryService.save(Country.builder().name("Ukraine").code("URK").build());
        Country usa =countryService.save(Country.builder().name("United States").code("USA").build());
        Country uzbekistsan = countryService.save(Country.builder().name("Uzbekistan").code("UZB").build());
        
        Boxer pin = boxerService.save(Boxer.builder().country(countryService.findByCode("PL")).division(Division.Heavyweight).name("Artur Szpilka").draw(0).lost(1).won(29).nick("Pin").stance(Stance.southpaw).build());
        Boxer iron = boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Heavyweight).name("Mike Tyson").draw(2).lost(3).won(45).nick("Iron Mike").stance(Stance.orthodox).build());
        Boxer jr = boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Light_Heavyweight).name("Roy Jones Jr").draw(2).lost(3).won(46).nick("jr").stance(Stance.orthodox).build());
        
        
        Boxer fist= boxerService.save(Boxer.builder().country(countryService.findByCode("URK")).division(Division.Heavyweight).name("Wladimir Klitschko").draw(0).lost(3).won(63).nick("Dr Steelhammer").stance(Stance.orthodox).build());
        Boxer kapitan = boxerService.save(Boxer.builder().country(countryService.findByCode("GER")).division(Division.Cruiserweight).name("Marco Huck").draw(1).lost(2).won(38).nick("Kapitan").stance(Stance.orthodox).build());
        Boxer superman = boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Light_Heavyweight).name("Adonis Stevenson").draw(0).lost(1).won(24).nick("SuperMan").stance(Stance.orthodox).build());
        Boxer cobra = boxerService.save(Boxer.builder().country(countryService.findByCode("GBR")).division(Division.Super_Middleweight).name("Carl Froch").draw(0).lost(2).won(33).nick("The Cobra").stance(Stance.orthodox).build());
        Boxer ggg = boxerService.save(Boxer.builder().country(countryService.findByCode("KAZ")).division(Division.Middleweight).name("Gennady Golovkin").draw(0).lost(0).won(31).nick("GGG").stance(Stance.orthodox).build());
        Boxer cancelo = boxerService.save(Boxer.builder().country(countryService.findByCode("MEX")).division(Division.Lightweight).name("Saul Alvarez").draw(1).lost(1).won(44).nick("Canelo").stance(Stance.orthodox).build());
        Boxer money= boxerService.save(Boxer.builder().country(countryService.findByCode("USA")).division(Division.Welterweight).name("Floyd Mayweather Jr").draw(1).lost(0).won(47).nick("Money / Pretty Boy").stance(Stance.orthodox).build());
        
        Boxer pac = boxerService.save(Boxer.builder().country(countryService.findByCode("PHI")).division(Division.Welterweight).name("Manny Pacquiao").draw(2).lost(5).won(57).nick("Pac Man").stance(Stance.southpaw).build());
        Boxer dinamita = boxerService.save(Boxer.builder().country(countryService.findByCode("MEX")).division(Division.Welterweight).name("Juan Manuel Marquez").draw(1).lost(7).won(56).nick("Dinamita").stance(Stance.orthodox).build());
     
        Place place = Place.builder().city("Warsaw").country(poland).location(new Location(123.343d, 231.323d)).build();
        fightService.save(Fight.builder().winner(fist).loser(pin).fightDate(new Date()).roundCount(12).place(place).build());
        
        place = Place.builder().city("Macco").country(china).location(new Location(144.343d, 531.323d)).build();
        fightService.save(Fight.builder().winner(pac).loser(money).fightDate(new Date()).roundCount(10).place(place).build());
        
    }
    
    
}
