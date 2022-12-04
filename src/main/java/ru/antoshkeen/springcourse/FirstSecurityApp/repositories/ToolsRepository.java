package ru.antoshkeen.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;

import java.util.List;

@Repository
public interface ToolsRepository extends JpaRepository<Tool, Integer> {

    @Query(nativeQuery = true, value = "select * from tool t where t.personid = :ownerId")
    List<Tool> findByPersonId(int ownerId);

}
