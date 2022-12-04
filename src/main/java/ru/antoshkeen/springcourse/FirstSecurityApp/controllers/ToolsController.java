package ru.antoshkeen.springcourse.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.ToolsRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.services.ToolsService;

@Controller
@RequestMapping("/tools")
public class ToolsController {
    private final ToolsService toolsService;

    //private final ToolsRepository toolsRepository;


    @Autowired
    public ToolsController(ToolsService toolsService,
                           ToolsRepository toolsRepository) {
        this.toolsService = toolsService;
        //this.toolsRepository = toolsRepository;
    }

    @GetMapping()
    public String indextool(Model model) {
        model.addAttribute("tools", toolsService.findAll());
        return "tools/indextool";
    }



    @GetMapping("/newtool")
    public String newTool(@ModelAttribute("tool") Tool tool) {
        return "tools/newtool";
    }

    @PostMapping()
    public String createTool(@ModelAttribute("tool") Tool tool, BindingResult bindingResult) {
        toolsService.save(tool);
        return "redirect:/tools";
    }
}
