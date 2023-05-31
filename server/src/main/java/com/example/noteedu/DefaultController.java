package com.example.noteedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DefaultController {
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String index() {
        return "forward:/";
    }
}
