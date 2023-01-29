package org.example.repasitory;

import org.example.entity.Lesson;

import java.util.List;

public interface LessonRepository {
    String saveLesson(Lesson lesson ,Long id);
    String updateLesson(Long id,Lesson lesson);
    Lesson getLessonById(Long id);
    List<Lesson> getLessonByCourseId(Long id);

}
