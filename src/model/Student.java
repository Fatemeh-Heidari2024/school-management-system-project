package model;

import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student extends Person{
    private double gpu;

    public Student() {
        super();
    }

    public Student(long id, String firstName, String lastName, String nationalCode, LocalDate dataOfBirth, double gpu) {
        super(id, firstName, lastName, nationalCode, dataOfBirth);
        this.gpu = gpu;
    }

    public Student(String firstName, String lastName, String nationalCode, LocalDate dataOfBirth, double gpu) {
        super(firstName, lastName, nationalCode, dataOfBirth);
        this.gpu = gpu;
    }

    public double getGpu() {
        return gpu;
    }

    public void setGpu(double gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString()+
                "gpu=" + gpu +
                "} ";
    }
}

