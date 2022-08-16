package com.deloitte.tot.hellokubeuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloKubeUserController {
    @Autowired
    private RestTemplate restTemplate;
    private final Environment env;
    @Autowired
    private AppConfig appConfig;

    public HelloKubeUserController(Environment env){
     this.env = env;
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> askQuestion(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok("Hello " + name + ", to Kubernetes world .. ");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> askQuestionEnv() {
        String url  = env.getProperty("url");
        String username = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok("Hello " + username + ", to Kubernetes world .. ");
    }
}
