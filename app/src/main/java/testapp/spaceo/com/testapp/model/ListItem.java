package testapp.spaceo.com.testapp.model;


import io.realm.RealmObject;

public class ListItem extends RealmObject {
    String title;
    String description;

    public ListItem() {
    }

    public ListItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
