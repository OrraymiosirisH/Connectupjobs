package guevara.alvarez.demo.repositories;

import guevara.alvarez.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);
    Long countByEmail(String email);
    Long countAllByUsername(String username);

}
