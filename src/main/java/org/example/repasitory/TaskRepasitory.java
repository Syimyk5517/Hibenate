package org.example.repasitory;

import org.example.entity.Task;

import java.util.List;

public interface TaskRepasitory {
    String saveTask(Task task,Long lessonId);
    String updateTask(Long id, Task task);
    List<Task> getAllTaskById(Long id);
    String deleteTaskById(Long id);
}
