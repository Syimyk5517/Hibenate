package org.example.service.seviceImpl;

import org.example.entity.Task;
import org.example.repasitory.TaskRepasitory;
import org.example.repasitory.repasitoryImpl.TaskRepositoryImpl;
import org.example.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    TaskRepasitory taskRepasitory = new TaskRepositoryImpl();
    @Override
    public String saveTask(Task task,Long lessonId) {
        taskRepasitory.saveTask(task,lessonId);
        return "!!!!";
    }

    @Override
    public String updateTask(Long id, Task task) {
        taskRepasitory.updateTask(id,task);
        return "!!!";
    }

    @Override
    public List<Task> getAllTaskById(Long id) {
        return taskRepasitory.getAllTaskById(id);
    }

    @Override
    public String deleteTaskById(Long id) {
        taskRepasitory.deleteTaskById(id);
        return "!!!";
    }
}
