package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "lesson")
@Entity
@NoArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "coourse_name")
    private  String courseName;
    private int duration;
    @Column(name = "create_at")
    private LocalDate createAt;
    private String imageLink;
    private String description;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.DETACH},fetch = FetchType.LAZY)
    private List<Instructor> instructors;
    @OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<>();

    public Course(String courseName, int duration, LocalDate createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;

    }

    @Override
    public String toString() {
        return "Course{" +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", createAt=" + createAt +
                ", imageLink='" + imageLink + '\'' +
                ", description=" + description + '}';
    }
}
