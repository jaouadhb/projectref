package fr.reference.it.projectref.springmvc.controller;

import fr.reference.it.projectref.security.rest.config.JwtTokenGenerator;
import fr.reference.it.projectref.security.rest.config.JwtUserDetails;
import fr.reference.it.projectref.security.rest.config.model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    JwtTokenGenerator jwtTokenGenerator;

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){
        return jwtTokenGenerator.generate(jwtUser);
    }
}
