package guevara.alvarez.demo.repositories;

import guevara.alvarez.demo.models.Job;
import guevara.alvarez.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {

    Job findByCompany(String username);

    Job findByEmail(String email);
    Long countByEmail(String email);
    Long countAllByCompany(String username);

}
