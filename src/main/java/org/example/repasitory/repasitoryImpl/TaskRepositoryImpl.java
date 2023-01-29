package org.example.repasitory.repasitoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.repasitory.TaskRepasitory;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepasitory,AutoCloseable{
    private  final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveTask(Task task,Long lessonId) {
        List<Task> taskList = new ArrayList<>();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        taskList.addAll(lesson.getTasks());
        taskList.add(task);
        lesson.setTasks(taskList);
        entityManager.persist(task);
        entityManager.merge(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "jhhhj";
    }

    @Override
    public String updateTask(Long id, Task task) {
        entityManager.getTransaction().begin();
        Task oldTAsk = entityManager.find(Task.class, id);
        oldTAsk.setTask(task.getTask());
        oldTAsk.setDeadline(task.getDeadline());
        oldTAsk.setTask(task.getTask());
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public List<Task> getAllTaskById(Long id) {
        entityManager.getTransaction().begin();
        List<Task> tasks = entityManager.createQuery("select t from Task t", Task.class).getResultStream().filter(t->t.getId().equals(id)).toList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @Override
    public String deleteTaskById(Long id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class,id);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "HGFDFGHJKL";
    }

    @Override
    public void close() throws Exception {
        entityManager.close();

    }
}
