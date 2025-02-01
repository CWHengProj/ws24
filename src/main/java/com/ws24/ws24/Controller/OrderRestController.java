package com.ws24.ws24.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    @GetMapping("")
    public ResponseEntity<String> getReponse() {
        return ResponseEntity.status(200).body("HEEEE");
    }
    
}
