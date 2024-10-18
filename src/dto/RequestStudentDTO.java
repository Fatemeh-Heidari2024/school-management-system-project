package dto;

public class RequestStudentDTO {
    private String oldName;
    private String newName;
    private String natCode;
    private long id;

    public RequestStudentDTO(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    public RequestStudentDTO(String natCode) {
        this.natCode = natCode;
    }

    public RequestStudentDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public RequestStudentDTO(String natCode, long id) {
        this.natCode = natCode;
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNatCode() {
        return natCode;
    }

    public void setNatCode(String natCode) {
        this.natCode = natCode;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
