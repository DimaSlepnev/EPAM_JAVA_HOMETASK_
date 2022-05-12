package advanced.java.ua.univer.practice8.DOT_Level;

import java.sql.Date;

public class ActorDTO extends MyEntity {
    private int id;
    private String fullName;
    private Date birthdate;

    public ActorDTO(int id, String fullName, Date birthdate) {
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
