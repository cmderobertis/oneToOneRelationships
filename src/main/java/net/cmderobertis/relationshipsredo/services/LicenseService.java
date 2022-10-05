package net.cmderobertis.relationshipsredo.services;
import net.cmderobertis.relationshipsredo.models.License;
import net.cmderobertis.relationshipsredo.repositories.LicenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {
    private final LicenseRepository repo;
    public LicenseService(LicenseRepository repo) {
        this.repo = repo;
    }
    // CREATE
    public License create(License license) {
        return repo.save(license);
    }
    // READ
    public List<License> getAll() {
        return repo.findAll();
    }
    public License getOne(Long id) {
        Optional<License> license = repo.findById(id);
        return license.orElse(null);
    }
    // UPDATE
    public License update(License license) {
        License l = getOne(license.getId());
        l.setNumber(license.getNumber());
        l.setExpirationDate(license.getExpirationDate());
        l.setState(license.getState());
        l.setPerson(license.getPerson());
        return repo.save(l);
    }
    //DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
