package net.cmderobertis.relationshipsredo.controllers;

import net.cmderobertis.relationshipsredo.models.License;
import net.cmderobertis.relationshipsredo.services.LicenseService;
import net.cmderobertis.relationshipsredo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LicenseController {
    @Autowired
    LicenseService service;
    @Autowired
    PersonService personService;

    @GetMapping("/licenses/new")
    String createForm(Model model, @ModelAttribute("license") License license) {
        model.addAttribute("persons", personService.getAll().stream().filter((person) -> person.getLicense() == null).collect(Collectors.toList()));
        return "createLicense.jsp";
    }

    @PostMapping("/licenses")
    String create(
            @Valid
            @ModelAttribute("license") License license,
            BindingResult result) {
        if (result.hasErrors()) {
            return "createLicense.jsp";
        } else {
            service.create(license);
            return "redirect:/licenses";
        }
    }

    @GetMapping("/licenses")
    String showAll(Model model) {
        List<License> licenses = service.getAll();
        model.addAttribute("licenses", licenses);
        return "licenses.jsp";
    }
    @GetMapping("/licenses/{id}")
    String showOne(@PathVariable("id") Long id, Model model) {
        model.addAttribute("license", service.getOne(id));
        return "showLicense.jsp";
    }
    @GetMapping("/licenses/{id}/edit")
    String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("license", service.getOne(id));
        model.addAttribute("persons", personService.getAll().stream().filter((person) -> person.getLicense() == null).collect(Collectors.toList()));
        return "updateLicense.jsp";
    }
    @PutMapping("/licenses/{id}")
    String update(
            @Valid
            @ModelAttribute("license") License license,
            BindingResult result) {
        if (result.hasErrors()) {
            return "updateLicense.jsp";
        } else {
            service.update(license);
            return "redirect:/licenses";
        }
    }
    @DeleteMapping("/licenses/{id}")
    String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/licenses";
    }
}
