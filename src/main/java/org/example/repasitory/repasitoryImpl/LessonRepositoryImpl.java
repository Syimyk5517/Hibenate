package org.example.repasitory.repasitoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.repasitory.LessonRepository;

import java.util.List;

public class LessonRepositoryImpl implements LessonRepository,AutoCloseable{
    private  final EntityManager entityManager = HibernateConfig.getEntityManager();



    @Override
    public String saveLesson(Lesson lesson, Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.merge(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "kejf";
    }

    @Override
    public String updateLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, id);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        lesson1.setTasks(lesson.getTasks());
        lesson1.setCourse(lesson1.getCourse());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "udj";
    }

    @Override
    public Lesson getLessonById(Long id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.createQuery("select l from Lesson  l", Lesson.class).getResultStream().filter(l->l.getId().equals(id)).findAny().orElseThrow();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        entityManager.getTransaction().begin();
        List<Lesson> lessons = entityManager.createQuery("select l from Lesson l join Course c on  c.id = l.id", Lesson.class).getResultStream().filter(c->c.getId().equals(id)).toList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lessons;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
