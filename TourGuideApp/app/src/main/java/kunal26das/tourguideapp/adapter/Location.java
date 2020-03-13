package kunal26das.tourguideapp.adapter;

/**
 * Created by kunal on 12-03-2020.
 */
public class Location {

    private String name;
    private String info;

    public Location(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }
}
