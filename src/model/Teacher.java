package model;

import java.time.LocalDate;

public class Teacher extends Person {
    public Teacher() {
    }

    public Teacher(long id, String firstName, String lastName, String nationalCode, LocalDate dataOfBirth) {
        super(id, firstName, lastName, nationalCode, dataOfBirth);
    }
    public Teacher(String firstName, String lastName, String nationalCode, LocalDate dataOfBirth) {
        super(firstName, lastName, nationalCode, dataOfBirth);
    }

    @Override
    public String toString() {
        return "Teacher{"+super.toString()+"}";
    }
}
