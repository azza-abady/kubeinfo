package com.deloitte.tot4.helloKube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloKubeController {
    @Autowired
    private AppConfig appConfig;

    private final Environment env;

    public HelloKubeController(Environment env) {
        this.env = env;
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> askQuestion(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok("Hello " + name + ", to Kubernetes world .. ");
    }

    @GetMapping("/env")
    public ResponseEntity<String> askQuestionEnv() {
        return ResponseEntity.ok("Hello " + env.getProperty("user") + ", to Kubernetes world .. ");
    }

    @GetMapping("/username")
    public ResponseEntity<String> askQuestion() {
        return ResponseEntity.ok(appConfig.getName());
    }
}
