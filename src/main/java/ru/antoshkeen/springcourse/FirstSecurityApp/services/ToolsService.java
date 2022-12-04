package ru.antoshkeen.springcourse.FirstSecurityApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.ToolsRepository;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ToolsService {

    private final ToolsRepository toolsRepository;
    private final PeopleRepository peopleRepository;


    @Autowired
    public ToolsService(ToolsRepository toolsRepository, PeopleRepository peopleRepository) {
        this.toolsRepository = toolsRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Tool> findAll() {
        return toolsRepository.findAll();
    }


    @Transactional
    public void save(Tool tool) {
        toolsRepository.save(tool);
    }

}
