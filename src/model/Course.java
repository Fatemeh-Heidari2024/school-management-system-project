package model;

public class Course extends BaseEntity{
    private String title;
    private int unit;

    public Course(long id, String title, int unit) {
        super(id);
        this.title = title;
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", unit=" + unit +
                '}';
    }
}
