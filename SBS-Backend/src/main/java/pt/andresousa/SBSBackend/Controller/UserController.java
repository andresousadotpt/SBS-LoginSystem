package pt.andresousa.SBSBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.andresousa.SBSBackend.Entity.User;
import pt.andresousa.SBSBackend.Repository.UserRepository;

@Controller // This tells that this class is a controller
@RequestMapping("/api/v1/user") // This tells that our url starts with /api/v1
public class UserController {

    @Autowired
    private UserRepository userRepo;


    @PostMapping("/add")
    public @ResponseBody String add(@RequestParam String username,
                                    @RequestParam String email,
                                    @RequestParam String password){

        User user = new User()
                .username(username)
                .email(email)
                .password(new BCryptPasswordEncoder().encode(password));

        userRepo.save(user);

        return "User saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> all(){
        return userRepo.findAll();
    }
}
