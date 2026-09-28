package uk.ac.westminster.products_api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class InfoController {
    @GetMapping("/info")
        public String info(){
        return "This is the info controller - " + LocalDate.now().toString();
    }

}
