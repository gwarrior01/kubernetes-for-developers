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

    @GetMapping("/name")
    public ResponseEntity<String> name() {
        return ResponseEntity.ok(System.getenv("KUBERNETES_POD_NAME"));
    }

    @GetMapping("/default")
    public ResponseEntity<String> defaultTime() {
        return ResponseEntity.ok(System.getenv("DEFAULT_TIME"));
    }

    @GetMapping("/secret")
    public ResponseEntity<String> secretTime() {
        return ResponseEntity.ok(System.getenv("SECRET_TIME"));
    }
}