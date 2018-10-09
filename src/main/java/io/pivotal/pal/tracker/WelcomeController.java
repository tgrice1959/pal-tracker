package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${greeting:Hello}")
    private String greeting;


    private final String welcomeMsg;


    public WelcomeController(@Value("${WELCOME_MESSAGE:Hello}") String a_welcome_message, @Value("${greeting:Hello}") String greeting) {
        this.welcomeMsg = a_welcome_message;
        this.greeting = greeting;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String  name) {
        return String.format("%s %s", greeting, name);
    }

    @GetMapping("/")
    public String sayWelcome()
    {
        return welcomeMsg;
    }

}
