package org.example.service.seviceImpl;

import org.example.entity.Lesson;
import org.example.repasitory.LessonRepository;
import org.example.repasitory.repasitoryImpl.LessonRepositoryImpl;
import org.example.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    LessonRepository lessonRepository = new LessonRepositoryImpl();
    @Override
    public String saveLesson(Lesson lesson, Long id) {
        lessonRepository.saveLesson(lesson,id);
        return "!!!";
    }

    @Override
    public String updateLesson(Long id, Lesson lesson) {
        lessonRepository.updateLesson(id,lesson);
        return "!!!";
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        return lessonRepository.getLessonByCourseId(id);
    }
}
