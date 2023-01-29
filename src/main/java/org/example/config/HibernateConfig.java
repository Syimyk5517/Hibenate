package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateConfig {

    public static  EntityManager getEntityManager() {

       org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        configuration.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(Environment.USER, "postgres");
        configuration.setProperty(Environment.PASS, "syimyk");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Task.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Lesson.class);
        return configuration.buildSessionFactory().createEntityManager();


}
    }