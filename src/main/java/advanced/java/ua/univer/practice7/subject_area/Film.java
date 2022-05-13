package advanced.java.ua.univer.practice7.subject_area;

import java.util.Date;

public class Film {
    private int id;
    private String name;
    private Date dateOfProduction;
    private String Country;

    public Film(int id, String name, Date dateOfProduction, String country) {
        this.id = id;
        this.name = name;
        this.dateOfProduction = dateOfProduction;
        Country = country;
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
        return Country;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfProduction=" + dateOfProduction +
                ", Country='" + Country + '\'' +
                "}\n";
    }
}
