package model;

import java.time.LocalDate;

public class Exam extends BaseEntity{
    private LocalDate date;
    private char grade;

    public Exam(long id, LocalDate date, char grade) {
        super(id);
        this.date = date;
        this.grade = grade;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "date=" + date +
                ", grade=" + grade +
                '}';
    }

}
