package advanced.java.ua.univer.practice7.subject_area;

import java.util.Date;

public class Actor {

    private int id;
    private String fullName;
    private Date birthdate;

    public Actor(int id, String fullName, Date birthdate) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                " fullName='" + fullName + '\'' +
                ", birthdate=" + birthdate +
                "}\n";
    }
}
