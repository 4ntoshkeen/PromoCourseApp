package ru.antoshkeen.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
