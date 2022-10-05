package net.cmderobertis.relationshipsredo.repositories;
import net.cmderobertis.relationshipsredo.models.Person;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}