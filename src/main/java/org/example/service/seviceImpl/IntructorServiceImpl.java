package org.example.service.seviceImpl;

import org.example.entity.Instructor;
import org.example.repasitory.InstructorRepasitory;
import org.example.repasitory.repasitoryImpl.InstructorRepasitoryImpl;
import org.example.service.InstructorService;

public class IntructorServiceImpl implements InstructorService {
    InstructorRepasitory instructorRepasitory = new InstructorRepasitoryImpl();
    @Override
    public String saveInnstructor(Instructor instructor) {
        instructorRepasitory.saveInnstructor(instructor);
        return "!!!!!";
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorRepasitory.updateInstructor(id,instructor);
    }

    @Override
    public Instructor getIstructorById(Long id) {
        return instructorRepasitory.getIstructorById(id);
    }

    @Override
    public Instructor getInctructorByCourseId(Long id) {
        return instructorRepasitory.getInctructorByCourseId(id);
    }

    @Override
    public String deleteIndtructorByid(Long id) {
        instructorRepasitory.deleteIndtructorByid(id);
        return "!!!!";
    }

    @Override
    public String assignInstructorTocourse(Long instructorId, Long courseId) {
        instructorRepasitory.assignInstructorTocourse(instructorId,courseId);
        return "!!!!";
    }
}
