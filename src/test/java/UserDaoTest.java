import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDaoTest {
    private final User USER_IN_LIST=new User("don");
    private final User USER_NO_IN_LIST=new User("topa");
    private final UserDao userDao=new UserDaoImpl();

    @Test
    public void shouldReturnNameOnCorrectName() {
        Assertions.assertEquals(userDao.getUserByName(USER_IN_LIST.getName()),USER_IN_LIST);
    }
    @Test
    public void shouldReturnNullOnIncorrectName() {
        Assertions.assertNull(userDao.getUserByName(USER_NO_IN_LIST.getName()));
    }
}