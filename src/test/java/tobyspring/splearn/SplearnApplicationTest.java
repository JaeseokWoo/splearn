package tobyspring.splearn;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class SplearnApplicationTest {
    @Test
    void run() {
        try (MockedStatic<SpringApplication> mocked = Mockito.mockStatic(SpringApplication.class)) { // try 안에 설정이 블록을 빠져 나가면 close를 해준다. try-with-resource 문법
            SplearnApplication.main(new String[0]);

            mocked.verify(() -> SpringApplication.run(SplearnApplication.class, new String[0]));
        }
    }

}
