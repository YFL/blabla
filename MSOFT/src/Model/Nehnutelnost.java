package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Nehnutelnost {
    int evidovana;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;

    private static int lastId = 0;

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getType() {
        return type.get();
    }

    public void setTyp(String name) {
        this.type.set(name);
    }

    public int getEvidovana() {
        return evidovana;
    }

    public void setEvidovana(int id) {
        this.evidovana = 1;
    }

    public Nehnutelnost(String name, String type) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty(newId());
        this.type = new SimpleStringProperty(type);
    }
    public SimpleStringProperty getNameProp() {
        return name;
    }

    public SimpleIntegerProperty getIdProp() {
        return id;
    }

    public SimpleStringProperty getTypeProp() {
        return type;
    }

    private static int newId()
    {
        return ++lastId;
    }
}