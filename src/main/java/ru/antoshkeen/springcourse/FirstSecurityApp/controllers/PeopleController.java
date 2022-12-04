package ru.antoshkeen.springcourse.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Person;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.ToolsRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.security.UsersDetails;
import ru.antoshkeen.springcourse.FirstSecurityApp.services.PeopleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final ToolsRepository toolsRepository;

    @Autowired
    public PeopleController(PeopleService peopleService,
                            ToolsRepository toolsRepository) {
        this.peopleService = peopleService;
        this.toolsRepository = toolsRepository;

    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "people/index";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails) authentication.getPrincipal();
        System.out.println(usersDetails.getUser());

        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", peopleService.findOne(id));
        model.addAttribute("tools", peopleService.getToolsByPersonId(id));
        model.addAttribute("operations", peopleService.getOperationsByPersonId(id));

        System.out.println(toolsRepository.findByPersonId(id));

        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }



    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";
        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }
}
