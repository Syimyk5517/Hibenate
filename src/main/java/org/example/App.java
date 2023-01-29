package org.example;


import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.service.CourseService;
import org.example.service.InstructorService;
import org.example.service.LessonService;
import org.example.service.TaskService;
import org.example.service.seviceImpl.CorurseServiceImpl;
import org.example.service.seviceImpl.IntructorServiceImpl;
import org.example.service.seviceImpl.LessonServiceImpl;
import org.example.service.seviceImpl.TaskServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        HibernateConfig.getEntityManager();
        CourseService courseService = new CorurseServiceImpl();
        InstructorService instructorService = new IntructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService taskService = new TaskServiceImpl();
        Course course1 = new Course("Java", 900, LocalDate.of(2022, 10, 3), "Photo", "Programing");
        Course course2 = new Course("JavaScript", 9, LocalDate.of(2021, 9, 2), "Photo", "Programing");
        Instructor instructor1 = new Instructor("Aijamal", "Assangazieva", "aijamal@gmail.com", "+996777975635");
        Instructor instructor2 = new Instructor("Albina", "Nurustanova", "a@gmail.com", "+996709070707");
        Lesson lesson1 = new Lesson("OOP", "life");
        Lesson lesson2 = new Lesson("HTML", "in LMS");
        Task task1 = new Task("Abstrackt", LocalDate.of(2023, 1, 26), "What is OOP ?");
        Task task2 = new Task("CSS", LocalDate.of(2023, 1, 26), "Teg");

        while (true) {
            System.out.println("""
                                 ======COURSE COMMANDS======
                                 1.SAVE COURSE : 
                                 2.GET COURSE BY ID :
                                 3.GET ALL COURSE :
                                 4.UPDATE COURSE :
                                 5.DELETE COURSE BY ID :
                                 6.GET COURSE BY NAME :
                                 ======INSTRUCTOR COMMANDS======
                                 7.SAVE INSTRUCTOR :
                                 8.UPDATE INSTRUCTOR :
                                 9.GET INSTRUCTOR BY ID :
                                 10.GET INSTRUCTOR BY COURSE ID :
                                 11.DELETE INSTRUCTOR BY ID :
                                 12.ASSIGN INSTRUCTOR TO COURSE :
                                 ======LESSON COMMANDS======
                                 13.SAVE LESSON :
                                 14.UPDATE LESSON :
                                 15.GET LESSON BY ID :
                                 16.GET LESSON BY COURSE ID :
                                 ======TASK COMMANDS======
                                 17.SAVE TASK :
                                 18.UPDATE TASK :
                                 19.GET ALL TASK BY LESSON ID :
                                 20.DELETE TASK BY ID : 
                                 =====   ENTER BY COMMANDS  ====""");

            int com = new Scanner(System.in).nextInt();
            switch (com) {
                case 1 -> courseService.saveCourse(course1);
                case 2 -> {
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(courseService.getCourseById(courseId));
                }
                case 3 -> System.out.println(courseService.getallCorse());
                case 4 -> {
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    courseService.update(courseId, course2);
                }
                case 5 -> {
                    System.out.println("Enter by course id:");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(courseService.deleteCourseById(courseId));
                }
                case 6 -> {
                    System.out.println("Enter by course name");
                    String courseName = new Scanner(System.in).nextLine();
                    System.out.println(courseService.getCourseByName(courseName));
                }
                case 7 -> System.out.println(instructorService.saveInnstructor(instructor1));
                case 8 -> {
                    System.out.println("Enter by instructor id :");
                    Long instructorId = new Scanner(System.in).nextLong();
                    instructorService.updateInstructor(instructorId, instructor2);
                }
                case 9 -> {
                    System.out.println("Enter by instructor id :");
                    Long instructorId = new Scanner(System.in).nextLong();
                    System.out.println(instructorService.getIstructorById(instructorId));
                }
                case 10 -> {
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(instructorService.getInctructorByCourseId(courseId));
                }
                case 11 -> {
                    System.out.println("Enter by instructorId :");
                    Long instructorId = new Scanner(System.in).nextLong();
                    System.out.println(instructorService.getIstructorById(instructorId));
                }
                case 12 -> {
                    System.out.println("Enter by instructor id :");
                    Long instructorId = new Scanner(System.in).nextLong();
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(instructorService.assignInstructorTocourse(instructorId, courseId));
                }
                case 13 -> {
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(lessonService.saveLesson(lesson1, courseId));
                }
                case 14 -> {
                    System.out.println("Enter by lesson id :");
                    Long lessonId = new Scanner(System.in).nextLong();
                    System.out.println(lessonService.updateLesson(lessonId, lesson2));
                }
                case 15 -> {
                    System.out.println("Enter by lesson id :");
                    Long lessonId = new Scanner(System.in).nextLong();
                    System.out.println(lessonService.getLessonById(lessonId));
                }
                case 16 -> {
                    System.out.println("Enter by course id :");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(lessonService.getLessonByCourseId(courseId));
                }
                case 17 -> {
                    System.out.println("Enter by lesson id :");
                    Long lessonId = new Scanner(System.in).nextLong();
                    System.out.println(taskService.saveTask(task1,lessonId));
                }
                case 18 -> {
                    System.out.println("Enter by task id :");
                    Long taskId = new Scanner(System.in).nextLong();
                    System.out.println(taskService.updateTask(taskId, task2));
                }
                case 19 -> {
                    System.out.println("Enter by lesson id :");
                    Long lessonId = new Scanner(System.in).nextLong();
                    System.out.println(taskService.getAllTaskById(lessonId));
                }
                case 20 -> {
                    System.out.println("Enter by task id :");
                    Long taskId = new Scanner(System.in).nextLong();
                    System.out.println(taskService.deleteTaskById(taskId));
                }
            }



    }
    }
}
