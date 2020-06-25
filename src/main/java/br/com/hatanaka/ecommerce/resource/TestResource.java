package br.com.hatanaka.ecommerce.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestResource {

    @GetMapping("teste")
    public ResponseEntity<Void> teste() {
        return ResponseEntity.ok().build();
    }
}
