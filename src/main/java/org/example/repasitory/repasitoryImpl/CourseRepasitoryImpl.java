package org.example.repasitory.repasitoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repasitory.CourseRepasitory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseRepasitoryImpl implements CourseRepasitory,AutoCloseable{
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "!!!!!";
    }

    @Override
    public Course getCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.createQuery("select c from Course c", Course.class).getResultStream().filter(c-> c.getId().equals(id)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public List<Course> getallCorse() {
        entityManager.getTransaction().begin();
       List<Course> courses = entityManager.createQuery("select c from Course c ", Course.class).getResultStream().sorted(Comparator.comparing(Course::getCreateAt)).toList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    public String deleteCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        for (Instructor inst : course.getInstructors()) {
            inst.setCourses(null);}
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        
        return"";
    }

    @Override
    public Course getCourseByName(String name) {
        entityManager.getTransaction().begin();
       Course course = entityManager.createQuery("select c from Course c", Course.class).getResultStream().filter(c -> c.getCourseName().equals(name)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public void update(Long id, Course course) {
        entityManager.getTransaction().begin();
        Course oldCourse = entityManager.find(Course.class, id);
        oldCourse.setCourseName(course.getCourseName());
        oldCourse.setDuration(course.getDuration());
        oldCourse.setCreateAt(course.getCreateAt());
        oldCourse.setImageLink(course.getImageLink());
        oldCourse.setDescription(course.getDescription());
        oldCourse.setInstructors(course.getInstructors());
        oldCourse.setLessons(course.getLessons());
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
