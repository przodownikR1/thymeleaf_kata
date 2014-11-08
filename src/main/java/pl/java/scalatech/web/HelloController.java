package pl.java.scalatech.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @Value("${application.message:Hello World}")
    private String message ;
    
    @RequestMapping("/")
    public String hi() {
        return "hi!!";
    }
    
    @RequestMapping("/json")
    public @ResponseBody Map<String, String> json() {

        Map<String, String> map = new HashMap<>();
        map.put("slawek", "borowiec");
        map.put("message",message);

        return map;
    }
    
    
    
}