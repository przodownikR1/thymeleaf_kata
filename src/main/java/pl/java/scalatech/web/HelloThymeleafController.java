package pl.java.scalatech.web;

import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
class HelloThymeleafController {
    @Value("${application.message:Hello World}")
    private String message;

    @RequestMapping("/hello")
    public String test(Model model) {

        model.addAttribute("time", LocalDate.now());
        model.addAttribute("message", message);
        log.info("{}  ", model);
        return "hello";
    }

}