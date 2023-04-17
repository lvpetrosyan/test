import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserParamTest {
    private static final String EMPTY_LOGIN_EMAIL = "";
    private static final String ONLY_SPACES_LOGIN_EMAIL = " ";
    private static final String DEFAULT_MESSAGE_EMPTY_PARAMETER = "введите значения";
    public static Stream<Arguments> provideParamsForTests(){
        return Stream.of(
                Arguments.of(EMPTY_LOGIN_EMAIL, ONLY_SPACES_LOGIN_EMAIL,DEFAULT_MESSAGE_EMPTY_PARAMETER)
        );
    }

}