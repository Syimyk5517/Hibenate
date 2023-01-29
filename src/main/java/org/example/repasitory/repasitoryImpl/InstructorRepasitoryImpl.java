package org.example.repasitory.repasitoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repasitory.InstructorRepasitory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructorRepasitoryImpl implements InstructorRepasitory,AutoCloseable{
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveInnstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "jhgh";
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        entityManager.getTransaction().begin();
        Instructor oldInstructor = entityManager.find(Instructor.class, id);
        oldInstructor.setFirstName(instructor.getFirstName());
        oldInstructor.setLastName(instructor.getLastName());
        oldInstructor.setEmail(instructor.getEmail());
        oldInstructor.setPhoneNumber(instructor.getPhoneNumber());
        oldInstructor.setCourses(instructor.getCourses());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Instructor getIstructorById(Long id) {
        entityManager.getTransaction().begin();
       Instructor instructor =  entityManager.createQuery("select i from Instructor i",Instructor.class).getResultStream().filter(i->i.getId().equals(id)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public Instructor getInctructorByCourseId(Long id) {
        entityManager.getTransaction().begin();
       Instructor instructor =  entityManager.createQuery("select i from Instructor i join Course c on c.id = i.id ",Instructor.class).getResultStream().filter(c->c.getId().equals(id)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public String deleteIndtructorByid(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class,id);
        for (Course c:instructor.getCourses()) {
            c.setInstructors(null);}
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Uspeshno";
    }

    @Override
    public String assignInstructorTocourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        List<Instructor> instructorList = new ArrayList<>(Arrays.asList(instructor));
        List<Course> courseList = new ArrayList<>(Arrays.asList(course));
        course.setInstructors(instructorList);
        instructor.setCourses(courseList);
        entityManager.merge(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "!!";
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
