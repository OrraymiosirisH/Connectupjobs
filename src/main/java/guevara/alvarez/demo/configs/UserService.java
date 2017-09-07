package guevara.alvarez.demo.configs;

import guevara.alvarez.demo.models.User;
import guevara.alvarez.demo.repositories.RoleRepository;
import guevara.alvarez.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Long countByEmail(String email) {
        return userRepository.CountByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

public void saveUser(User user){

        user.setRoles(Arrays.asList(roleRepository.findByRole("SEEKER")));
        user.setEnabled(true);
        userRepository.save(user);

}

    public void saveAdmin(User user){

        user.setRoles(Arrays.asList(roleRepository.findByRole("RECRU")));
        user.setEnabled(true);
        userRepository.save(user);

    }

}