package pl.java.scalatech.web;

import javax.validation.Valid;

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
import pl.java.scalatech.domain.Division;
import pl.java.scalatech.service.boxer.BoxerService;
@Controller
@RequestMapping("/boxer")
@Slf4j
public class BoxerController {
    private final static String BOXER_VIEW = "boxer/boxer";
    private final static String BOXER_EDIT = "boxer/boxerEdit";
    private final static String BOXER_REDIRECT = "redirect:/boxer/";
    @Autowired
    private BoxerService boxerService;
    
    @ModelAttribute("divisions")
    public Division[] divisions(){
        return Division.values();
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getAllBoxer(Model model) {
        model.addAttribute(boxerService.findAll());
        log.info("+++++++        {}",model);
        return BOXER_VIEW;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute(new Boxer());
        return BOXER_EDIT;
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String getCountryById(@PathVariable("id") Long id, Model model) {
        if (id == null) {
            model.addAttribute(new Boxer());
        }else{
            model.addAttribute(boxerService.findOne(id));
        }
        
        return BOXER_EDIT;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, Model model) {
        Boxer boxer = boxerService.findOne(id);
        boxerService.delete(boxer);
        return BOXER_REDIRECT;
    }

  
    @RequestMapping(value = { "", "/{id}" }, method = RequestMethod.POST)
    public String create(@Valid Boxer boxer, BindingResult result, Errors errors) {
        log.info("+++  boxer :  {}", boxer);
        // countryValidator.validate(invoice, errors);
        if (result.hasErrors()) {
            log.info("+++  invoice error  {}", result);
            return BOXER_EDIT;
        }
        boxerService.save(boxer);
        return BOXER_REDIRECT;
    }

}

