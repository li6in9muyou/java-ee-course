package fun.li6q.javaeetk4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String displayName;
    @Column(nullable = false)
    private String password;

    public User(String displayName, String password) {
        this.displayName = displayName;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
