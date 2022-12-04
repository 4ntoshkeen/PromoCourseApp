package ru.antoshkeen.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Operation;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;

import java.util.List;

@Repository
public interface OperationsRepository extends JpaRepository<Operation, Integer> {


}
