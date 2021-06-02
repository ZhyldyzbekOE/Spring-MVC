package kg.megacom.springweb.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {

    private int id;
    @Pattern(regexp = "[a-zA-Z]*")
    @NotEmpty(message = "Имя не должнен быть пустым!")
    @Size(min = 2, max = 15, message = "Имя должно быть между 2 и 15 символов")
    private String name;
    @NotEmpty(message = "Email не должнен быть пустым!")
    @Email(message = "Введите корректно: example@example.com")
    private String email;
    @NotEmpty
    @Size(min = 8, message = "Пароль должен быть не менее 8 сиволовов")
    @Pattern(regexp = "[a-zA-Z0-9!-&]*")
    private String password;
    private boolean isActive;

    public Person(){ }

    public Person(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
