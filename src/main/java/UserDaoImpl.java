import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {
    private List<User> userList = new ArrayList();
    private final User USER1 = new User("don");
    private final User USER2 = new User("cat");
    private final User USER3 = new User("dog");

    public UserDaoImpl() {
        this.userList = userList;
        userList.add(USER1);
        userList.add(USER2);
        userList.add(USER3);
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public User getUserByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    @Override
    public List<User> findAllUsers(){
        return userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDaoImpl userDao = (UserDaoImpl) o;
        return Objects.equals(userList, userDao.userList) && Objects.equals(USER1, userDao.USER1) && Objects.equals(USER2, userDao.USER2) && Objects.equals(USER3, userDao.USER3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList, USER1, USER2, USER3);
    }

}
