package model;

import java.time.LocalDate;

public class Exam extends BaseEntity{
    private LocalDate date;
    private int grade;
    private long courseId;

    public Exam(LocalDate date, int grade, long courseId) {
        this.date = date;
        this.grade = grade;
        this.courseId = courseId;
    }

    public Exam(long id, LocalDate date, int grade, long courseId) {
        super(id);
        this.date = date;
        this.grade = grade;
        this.courseId = courseId;
    }

    public Exam(long id, LocalDate date, int grade) {
        super(id);
        this.date = date;
        this.grade = grade;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Exam{" +super.toString()+
                ", date=" + date +
                ", grade=" + grade +
                ", courseId=" + courseId +
                "} ";
    }

}
