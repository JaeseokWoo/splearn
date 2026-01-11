package tobyspring.splearn.adapter.integration;

import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Component;
import tobyspring.splearn.application.required.EmailSender;
import tobyspring.splearn.domain.Email;

@Component
@Fallback // spring6.2에 들어간 기능, 다른 bean을 다 찾다가 다 찾아봤는데 찾을 수 없게 되었을 때, 대체로 이 bean을 사용한다.
public class DummyEmailSender implements EmailSender {
    @Override
    public void send(Email email, String subject, String body) {
        System.out.println("DummyEmailSender send email: " + email);
    }
}
