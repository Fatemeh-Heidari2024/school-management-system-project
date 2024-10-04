package model;

import exception.PasswordFormatProblemException;
import exception.UsernameFormatProblemException;
import util.CurrentUser;
import java.time.LocalDate;

public class Person extends BaseEntity{
    private String firstName;
    private String lastName;
    private String nationalCode;
    private LocalDate dataOfBirth;


    public Person(long id, String firstName, String lastName, String nationalCode, LocalDate dataOfBirth) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.dataOfBirth = dataOfBirth;
    }
    public Person( String firstName, String lastName, String nationalCode, LocalDate dataOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.dataOfBirth = dataOfBirth;
    }


    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public LocalDate getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    @Override
    public String toString() {
        return "" +super.toString()+","+
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", dataOfBirth=" + dataOfBirth+",";
    }
}
