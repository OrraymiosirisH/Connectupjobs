package guevara.alvarez.demo.repositories;

import guevara.alvarez.demo.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Iterable<Role>findAllById(Long Long);
    Iterable<Role>findRoleByRole(String String);

    Role findByRole(String role);
}