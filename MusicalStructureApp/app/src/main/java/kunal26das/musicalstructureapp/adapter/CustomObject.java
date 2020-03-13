package kunal26das.musicalstructureapp.adapter;

/**
 * Created by kunal on 11-03-2020.
 */
public class CustomObject {

    private String title;
    private String imageUrl;

    public CustomObject(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
