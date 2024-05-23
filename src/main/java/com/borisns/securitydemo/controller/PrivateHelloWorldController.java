package com.borisns.securitydemo.controller;

import com.borisns.securitydemo.model.Product;
import com.borisns.securitydemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hello-world")
public class PrivateHelloWorldController {


    @GetMapping(path = "/registered-user")
    public ResponseEntity<String> helloAnyRegisteredUser() {
        return new ResponseEntity<>("Hello ANY REGISTERED USER from PRIVATE controller!", HttpStatus.OK);
    }

    @GetMapping(path = "/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> helloUser() {
        return new ResponseEntity<>("Hello USER from PRIVATE controller!", HttpStatus.OK);
    }

    @GetMapping(path = "/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> helloAdmin() {
        return new ResponseEntity<>("Hello ADMIN from PRIVATE controller!", HttpStatus.OK);
    }


}
