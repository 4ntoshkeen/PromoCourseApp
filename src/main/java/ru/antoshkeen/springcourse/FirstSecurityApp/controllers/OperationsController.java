package ru.antoshkeen.springcourse.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Operation;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.OperationsRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.ToolsRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.services.OperationsService;
import ru.antoshkeen.springcourse.FirstSecurityApp.services.ToolsService;

@Controller
@RequestMapping("/operations")
public class OperationsController {


    private final OperationsService operationsService;

    //private final OperationsRepository operationsRepository;

    @Autowired
    public OperationsController(OperationsService operationsService, OperationsRepository operationsRepository) {
        this.operationsService = operationsService;
        //this.operationsRepository = operationsRepository;
    }


    @GetMapping()
    public String indexoperation(Model model) {
        model.addAttribute("operations", operationsService.findAll());
        return "operations/indexoperations";
    }



    @GetMapping("/newoperation")
    public String newOperation(@ModelAttribute("operation") Operation operation) {
        return "operations/newoperation";
    }

    @PostMapping()
    public String createOperation(@ModelAttribute("operation") Operation operation, BindingResult bindingResult) {
        operationsService.save(operation);
        return "redirect:/operations";
    }
}
