package ru.antoshkeen.springcourse.FirstSecurityApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.Tool;

import java.util.List;

@Component
public class PersonDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sesionFactory) {
        this.sessionFactory = sesionFactory;
    }

    @Transactional
    public List<Tool> getTools(int id, Tool tool) {
        String hql = "FROM Tool t WHERE t.id=:id";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<Tool> toolList = query.list();

        return toolList;
    }


    @Transactional
    public void saveTool(Tool tool) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tool);
    }
}
