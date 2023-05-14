package in.gmsk.entity;

public class User {

    private int id;
    private String name;
    private String location;
    private String mailId;

    public User() {
    }

    public User(int id, String name, String location, String mailId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.mailId = mailId;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", mailId='" + mailId + '\'' +
                '}';
    }
}
