package net.cmderobertis.relationshipsredo.services;
import net.cmderobertis.relationshipsredo.models.Person;
import net.cmderobertis.relationshipsredo.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repo;
    PersonService(PersonRepository repo) {
        this.repo = repo;
    }
    // CREATE
    public Person create(Person person) {
        return repo.save(person);
    }
    // READ
    public List<Person> getAll() {
        return repo.findAll();
    }
    public Person getOne(Long id) {
        Optional<Person> person = repo.findById(id);
        return person.orElse(null);
    }
    // UPDATE
    public Person update(Person person) {
        Person p = getOne(person.getId());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setLicense(person.getLicense());
        return repo.save(p);
    }
    //DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
