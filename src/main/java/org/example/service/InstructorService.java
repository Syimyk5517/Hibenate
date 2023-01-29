package org.example.service;

import org.example.entity.Instructor;

public interface InstructorService {
    String saveInnstructor(Instructor instructor);
    void updateInstructor(Long id, Instructor instructor);
    Instructor getIstructorById(Long id);
    Instructor getInctructorByCourseId(Long id);
    String deleteIndtructorByid(Long id );
    String assignInstructorTocourse(Long instructorId,Long courseId);

}
