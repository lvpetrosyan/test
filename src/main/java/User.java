import java.util.Objects;

public class User {
    private String login;
    private String email;


    private String name;

    public User(String login, String email) {
        if (login.isBlank()) {
            System.out.println(("Cтрока не может быть пустой"));
        } else if (login.equals(email)) {
            throw new RuntimeException("Логин и e-amil одинаковы!");
        } else {
            this.login = login;
        }
        if (email.isBlank()) {
            throw new NullPointerException("Cтрока не может быть пустой");
        } else if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else throw new RuntimeException("ВВедите верный e-mail");
    }

    public User(String name) {
        if (name.isBlank()) {
            System.out.println(("Cтрока не может быть пустой"));
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }
}
