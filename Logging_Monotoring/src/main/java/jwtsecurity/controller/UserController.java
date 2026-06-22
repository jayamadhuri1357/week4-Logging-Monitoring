package jwtsecurity.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/home")
    public String userHome() {
        return "Welcome User!";
    }
}