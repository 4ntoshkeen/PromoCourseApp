package ru.antoshkeen.springcourse.FirstSecurityApp.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Person;


import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {

        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setOperationDate(resultSet.getString("operationDate"));
        person.setCito(resultSet.getString("cito"));
        person.setTimeStart(resultSet.getString("timeStart"));
        person.setTimeFinish(resultSet.getString("timeFinish"));
        person.setName(resultSet.getString("name"));
        person.setRegion(resultSet.getString("region"));
        person.setBirthday(resultSet.getString("birthday"));
        person.setDepartment(resultSet.getString("department"));
        person.setHistoryNumber(resultSet.getInt("historyNumber"));
        person.setTimeDose(resultSet.getString("timeDose"));
        person.setDose(resultSet.getInt("dose"));
        person.setStents(resultSet.getInt("stents"));
        person.setElevation(resultSet.getString("elevation"));

        return person;
    }
}
