package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController<value> {

    @Value("${greeting:Hello}")
    private String greeting;

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String  name) {
        return String.format("%s %s", greeting, name);
    }
}
