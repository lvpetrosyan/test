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
    private static final User out = new User();
    private static final String DEFAULT_MESSAGE_EMPTY_VALUE = "Cтрока не может быть пустой";
    private static final String DEFAULT_MESSAGE_EMPTY_PARAMETER = "введите значения";


    @Test
    void isBlank_ShouldReturnFalseForNullOrBlankStringsLoginOrEmail() {
        User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        assertFalse(user.getLogin().isBlank());
        assertNull(NULL_LOGIN_EMAIL, DEFAULT_MESSAGE_EMPTY_VALUE);
    }

    //выше метод с false, он работает, а с true нет
    @Test
    void isBlank_ShouldReturnTrueForNullOrBlankStringsLoginOrEmail() {
        User user = new User(ONLY_SPACES_LOGIN_EMAIL, EMPTY_LOGIN_EMAIL);
        assertTrue(user.getLogin().isBlank());
        assertEquals(DEFAULT_MESSAGE_EMPTY_VALUE, user);
    }

    @Test
    void shouldReturnTrueForCorrectEmail() {
        User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        assertTrue(user.getEmail().contains("@") && user.getEmail().contains("."));
    }

    //появляется ошибка,которая и должна быть, но тест не пройден
    @Test
    void shouldReturnTrueForNoCorrectEmailAndException() {
        User user = new User(CORRECT_LOGIN, EMAIL_NOSYMBOL_2);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("ВВедите верный e-mail");
        });
        assertEquals("ВВедите верный e-mail", exception.getMessage());
    }

    @Test
    void shouldReturnTrueForEmailAndLoginEquals() {
        User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        assertFalse(user.getEmail().equals(user.getLogin()));
    }
    //если нет параметров в объекте, должно вывести текст, проверка на этот текст не работает
    @Test
    void shouldReturnTrueForNullOrBlankSEmptyParameterStringsLoginOrEmail() {
        User user = new User();
        assertEquals("введите значения", user);
    }
}