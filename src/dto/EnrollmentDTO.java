package dto;

public class EnrollmentDTO {
    private String firstName;
    private String lastName;
    private String courceTitle;

    public EnrollmentDTO(String firstName, String lastName, String courceTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courceTitle = courceTitle;
    }

    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", courceTitle='" + courceTitle + '\'' +
                '}';
    }
}
