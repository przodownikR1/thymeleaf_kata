package pl.java.scalatech.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fight")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FightController {
    private final static String FIGHT_VIEW = "fight/fight";
    private final static String FIGHT_EDIT = "fight/fightEdit";
    private final static String FIGHT_REDIRECT = "redirect:/fight/";
    
}
