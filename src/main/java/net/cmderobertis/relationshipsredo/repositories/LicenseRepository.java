package net.cmderobertis.relationshipsredo.repositories;

import net.cmderobertis.relationshipsredo.models.License;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();
}
