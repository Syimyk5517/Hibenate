package org.example.service.seviceImpl;

import org.example.entity.Course;
import org.example.repasitory.CourseRepasitory;
import org.example.repasitory.repasitoryImpl.CourseRepasitoryImpl;
import org.example.service.CourseService;

import java.util.List;

public class CorurseServiceImpl implements CourseService {
    CourseRepasitory courseRepasitory = new CourseRepasitoryImpl();
    @Override
    public String saveCourse(Course course) {
        courseRepasitory.saveCourse(course);
        return " !!!";
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepasitory.getCourseById(id);
    }

    @Override
    public List<Course> getallCorse() {
        return courseRepasitory.getallCorse();
    }

    @Override
    public String deleteCourseById(Long id) {
        courseRepasitory.deleteCourseById(id);
        return "!!!";
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepasitory.getCourseByName(name);

    }

    @Override
    public void update(Long id, Course course) {
        courseRepasitory.update(id,course);

    }
}
