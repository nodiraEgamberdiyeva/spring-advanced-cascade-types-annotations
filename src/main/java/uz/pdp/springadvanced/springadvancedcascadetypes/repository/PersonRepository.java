package uz.pdp.springadvanced.springadvancedcascadetypes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
