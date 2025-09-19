package com.multi.springboot.controller;

import com.multi.springboot.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    // 1. Hello World 버튼용
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    // 2. JSON Data 버튼용
    @GetMapping("/user")
    public UserDTO user(){
        return new UserDTO(11,"홍박사","a@a.a");
    }

    // 3. PathVariable 버튼용
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // 4. RequestParam 버튼용
    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

    // 5. POST Request 버튼용
    @PostMapping("/create")
    public String createUser(@RequestBody Map<String, String> userData) {
        return "User created: " + userData.get("name");
    }

    // 6. PUT Request 버튼용
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody Map<String, String> userData) {
        return "User " + id + " updated to " + userData.get("name");
    }

    // 7. DELETE Request 버튼용
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return "User " + id + " deleted.";
    }

    // 8. List Data 버튼용
    @GetMapping("/users")
    public List<UserDTO> getUserList() {
        return Arrays.asList(
                new UserDTO(1, "김철수", "kim@example.com"),
                new UserDTO(2, "이영희", "lee@example.com"),
                new UserDTO(3, "박민준", "park@example.com")
        );
    }

    // 9. ResponseEntity 버튼용
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Status: OK (200)");
    }

    // 10. Error Handling 버튼용
    @GetMapping("/error")
    public ResponseEntity<String> simulateError() {
        return ResponseEntity.status(500).body("Simulated Server Error!");
    }
}