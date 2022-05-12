package advanced.java.ua.univer.practice8.DOT_Level;

import java.sql.Date;

public class FilmDTO extends MyEntity {
    private int id;
    private String name;
    private Date dateOfProduction;
    private String country;

    public FilmDTO(int id, String name, Date dateOfProduction, String country) {
        this.id = id;
        this.name = name;
        this.dateOfProduction = dateOfProduction;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfProduction=" + dateOfProduction +
                ", Country='" + country + '\'' +
                "}\n";
    }
}

