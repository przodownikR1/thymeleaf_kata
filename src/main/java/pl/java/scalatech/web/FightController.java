package pl.java.scalatech.web;

import java.util.Set;

import javax.validation.Valid;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.java.scalatech.domain.Boxer;
import pl.java.scalatech.domain.Country;
import pl.java.scalatech.domain.Division;
import pl.java.scalatech.domain.Fight;
import pl.java.scalatech.repository.country.CountryRepository;
import pl.java.scalatech.service.boxer.BoxerService;
import pl.java.scalatech.service.fight.FightService;

import com.google.common.collect.Sets;

@Controller
@RequestMapping("/fight")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FightController {
    private final static String FIGHT_VIEW = "fight/fight";
    private final static String FIGHT_EDIT = "fight/fightEdit";
    private final static String FIGHT_REDIRECT = "redirect:/fight/";
    
    private final @NonNull FightService fightService;
    
    private final @NonNull CountryRepository countryRepository;
    
   
  
    @ModelAttribute("countries")
    public Set<Country> countries(){
        return Sets.newHashSet(countryRepository.findAll());
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getAllFight(Model model) {
        model.addAttribute(fightService.findAll());
        log.info("+++++++        {}",model);
        return FIGHT_VIEW;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute(new Fight());
        return FIGHT_EDIT;
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String getCountryById(@PathVariable("id") Long id, Model model) {
        if (id == null) {
            model.addAttribute(new Fight());
        }else{
            model.addAttribute(fightService.findOne(id));
        }
        
        return FIGHT_EDIT;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, Model model) {
        Fight fight = fightService.findOne(id);
        fightService.delete(fight);
        return FIGHT_REDIRECT;
    }

  
    @RequestMapping(value = { "", "/{id}" }, method = RequestMethod.POST)
    public String create(@Valid Fight fight, BindingResult result, Errors errors) {
        log.info("+++  fight :  {}", fight);
        // countryValidator.validate(invoice, errors);
        if (result.hasErrors()) {
            log.info("+++  invoice error  {}", result);
            return FIGHT_EDIT;
        }
        fightService.save(fight);
        return FIGHT_REDIRECT;
    }
}
