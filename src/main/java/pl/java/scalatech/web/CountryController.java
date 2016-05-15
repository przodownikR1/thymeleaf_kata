package pl.java.scalatech.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Country;
import pl.java.scalatech.service.country.CountryService;

@Controller
@RequestMapping("/country")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountryController {
    private final static String COUNTRY_VIEW = "country/country";
    private final static String COUNTRY_EDIT = "country/countryEdit";
    private final static String COUNTRY_REDIRECT = "redirect:/country/";

    private final @NonNull CountryService countryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getAllCountry(Model model) {
        model.addAttribute(countryService.findAll());
        log.info("+++++++        {}", model);
        return COUNTRY_VIEW;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute(new Country());
        return COUNTRY_EDIT;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String getCountryById(@PathVariable("id") Long id, Model model) {
        if (id == null) {
            model.addAttribute("country", new Country());
        } else {
            model.addAttribute("country", countryService.findOne(id));
        }

        return COUNTRY_EDIT;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Country country = countryService.findOne(id);
        countryService.delete(country);
        return COUNTRY_REDIRECT;
    }

    @RequestMapping(value = { "", "/{id}" }, method = RequestMethod.POST)
    public String create(@Valid Country country, BindingResult result, Errors errors) {
        log.info("+++  country save :  {}", country);
        // countryValidator.validate(invoice, errors);
        if (result.hasErrors()) {
            log.info("+++  invoice error  {}", result);
            return COUNTRY_EDIT;
        }
        countryService.save(country);
        return COUNTRY_REDIRECT;
    }

}
