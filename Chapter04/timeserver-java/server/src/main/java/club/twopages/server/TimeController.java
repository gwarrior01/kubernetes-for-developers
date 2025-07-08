package club.twopages.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class TimeController {

    @GetMapping
    public ResponseEntity<String> time() {
        return ResponseEntity.ok("Hello, TwoPages " + LocalDateTime.now());
    }
}