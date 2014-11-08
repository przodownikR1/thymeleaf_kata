package pl.java.scalatech.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HelloThymeleafController {
    @Value("${application.message:Hello World}")
    private String message;

    @RequestMapping("/hello")
    public String test(Model model) {
        model.addAttribute("time", LocalDate.now());
        model.addAttribute("message", message);
        return "hello";
    }

  

}