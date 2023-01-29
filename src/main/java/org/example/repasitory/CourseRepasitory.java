package org.example.repasitory;

import org.example.entity.Course;

import java.util.List;

public interface CourseRepasitory {
    String saveCourse(Course course);
Course  getCourseById(Long id);
    List<Course> getallCorse();
    String deleteCourseById(Long id);
    Course getCourseByName(String name);
    void update (Long id, Course course);

}
