package ru.antoshkeen.springcourse.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;
import ru.antoshkeen.springcourse.FirstSecurityApp.services.ToolsService;

import java.util.List;


@RestController
@RequestMapping("/alltools")
public class ToolsRESTController {

    private final ToolsService toolsService;

    @Autowired
    public ToolsRESTController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }


    @GetMapping()
    public List<Tool> getTools() {
        return toolsService.findAll();
    }
}
