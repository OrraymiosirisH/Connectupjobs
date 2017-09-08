package guevara.alvarez.demo.repositories;

import guevara.alvarez.demo.models.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Long> {


    Iterable<Skill>findSkillById(Long Long);
    Iterable<Skill>findAllByski(String String);

}
