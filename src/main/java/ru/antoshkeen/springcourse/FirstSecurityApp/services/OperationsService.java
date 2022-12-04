package ru.antoshkeen.springcourse.FirstSecurityApp.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Operation;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Person;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.OperationsRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.ToolsRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OperationsService {

    private final OperationsRepository operationsRepository;
    private final PeopleRepository peopleRepository;


    @Autowired
    public OperationsService(OperationsRepository operationsRepository, PeopleRepository peopleRepository) {
        this.operationsRepository = operationsRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Operation> findAll() {
        return operationsRepository.findAll();
    }


    @Transactional
    public void save(Operation operation) {
        operationsRepository.save(operation);
    }

    /*public List<Operation> getOperationsByPersonId(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        if (person.isPresent()) {
            Hibernate.initialize(person.get().getTools());
            return person.get().getOperations();
        }
        else { return Collections.emptyList(); }
    }*/

}
