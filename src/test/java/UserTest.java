import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static final String EMPTY_LOGIN_EMAIL = "";
    private static final String ONLY_SPACES_LOGIN_EMAIL = " ";
    private static final String NULL_LOGIN_EMAIL = null;
    private static final String CORRECT_LOGIN = "Link5000_00";
    private static final String CORRECT_EMAIL = "Link5000_00@mail.ru";
    private static final String EMAIL_NOSYMBOL_1 = "Link5000_00mail.ru";
    private static final String EMAIL_NOSYMBOL_2 = "Link5000_00mailru";
    private static final String EMAIL_EQUALS_LOGIN = "Link5000_00mailru";
    private static final String DEFAULT_MESSAGE_EMPTY_VALUE = "Cтрока не может быть пустой";


    @Test
    void isBlank_ShouldReturnFalseForNullOrBlankStringsLoginOrEmail() {
        User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        assertFalse(user.getLogin().isBlank());
    }

    @Test
    void shouldReturnTrueForCorrectEmail() {
        User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        assertTrue(user.getEmail().contains("@") && user.getEmail().contains("."));
    }

    @Test
    void shouldReturnTrueForNoCorrectEmailAndException() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            User user = new User(CORRECT_LOGIN, EMAIL_NOSYMBOL_2);
        });
        assertEquals("ВВедите верный e-mail", exception.getMessage());
    }

    @Test
    void shouldReturnTrueForEmailAndLoginEquals() {
        User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        assertFalse(user.getEmail().equals(user.getLogin()));
    }
}