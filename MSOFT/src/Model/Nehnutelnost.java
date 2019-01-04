package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Nehnutelnost {
    int id;
    String name;
    String typ;
    int evidovana;
    private final SimpleIntegerProperty idd;
    private final SimpleStringProperty nam;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String name) {
        this.typ = typ;
    }

    public int getEvidovana() {
        return evidovana;
    }

    public void setEvidovana(int id) {
        this.evidovana = 1;
    }

    public Nehnutelnost(int id, String name, String t ) {
        this.id = id;
        this.name = name;
        this.typ = t;
        this.nam = new SimpleStringProperty(name);
        this.idd = new SimpleIntegerProperty(id);
    }
    public String getNam() {
        return nam.get();
    }

    public int getIdd() {
        return idd.get();
    }
}