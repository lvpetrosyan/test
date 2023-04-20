import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private final User USER_IN_LIST=new User("don");
    private final User USER_NO_IN_LIST=new User("topa");
    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserService userService;
    @Test
    public void checkUserExistTrue() {
        when(userDaoMock.getUserByName(eq(USER_IN_LIST.getName()))).thenReturn(USER_IN_LIST);
        assertTrue(userService.checkUserExist(USER_IN_LIST));
    }
    @Test
    public void checkUserExistFalse() {
        when(userDaoMock.getUserByName(USER_NO_IN_LIST.getName())).thenReturn(null);
        assertFalse(userService.checkUserExist(USER_NO_IN_LIST));
    }
}