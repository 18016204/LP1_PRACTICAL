package sg.edu.rp.c346.id18016204.lp1practical;

import java.io.Serializable;

public class Task implements Serializable {
    private String description;
    private String date;

    public Task(String description, String date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
