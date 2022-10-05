package net.cmderobertis.relationshipsredo.controllers;
import net.cmderobertis.relationshipsredo.models.Person;
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
public class PersonController {
    @Autowired
    PersonService service;
    @GetMapping("/")
    String index() {
        return "redirect:/persons";
    }
    @GetMapping("/persons/new")
    String createForm(@ModelAttribute("person") Person person) {
        return "createPerson.jsp";
    }
    @PostMapping("/persons")
    String create(@ModelAttribute("person") Person person) {
        service.create(person);
        return "redirect:/persons";
    }
    @GetMapping("/persons")
    String showAll(Model model) {
        List<Person> persons = service.getAll();
        model.addAttribute("persons", persons);
        return "persons.jsp";
    }
    @GetMapping("/persons/{id}")
    String showOne(@PathVariable Long id, Model model) {
        Person person = service.getOne(id);
        model.addAttribute("person", person);
        return "showPerson.jsp";
    }
    @GetMapping("/persons/{id}/edit")
    String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", service.getOne(id));
        return "updatePerson.jsp";
    }
    @PutMapping("/persons/{id}")
    String update(
            @Valid
            @ModelAttribute("person") Person person,
            BindingResult result) {
        if (result.hasErrors()) {
            return "updatePerson.jsp";
        } else {
            service.update(person);
            return "redirect:/persons";
        }
    }
    @DeleteMapping("/persons/{id}")
    String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/persons";
    }
}
