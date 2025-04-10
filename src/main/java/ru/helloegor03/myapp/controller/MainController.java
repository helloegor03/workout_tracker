package ru.helloegor03.myapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/secured")
public class MainController {
    public String userAccess(Principal principal){
        if(principal == null)
            return null;
        return principal.getName();
    }
}
