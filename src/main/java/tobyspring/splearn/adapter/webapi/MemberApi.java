package tobyspring.splearn.adapter.webapi;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tobyspring.splearn.adapter.webapi.dto.MemberRegisterResponse;
import tobyspring.splearn.application.member.provided.MemberRegister;
import tobyspring.splearn.domain.member.Member;
import tobyspring.splearn.domain.member.MemberRegisterRequest;

@RestController
@RequiredArgsConstructor
public class MemberApi {
    private final MemberRegister memberRegister;

    @PostMapping("/api/members")
    public MemberRegisterResponse register(@RequestBody @Valid MemberRegisterRequest request) { // 메소드를 실행하기 전에 Bean Validation Annotation을 통해 검증하여 오류가 발생하면 Spring MVC가 적절한 Http status를 만들어 반환한다, @Validated도 있는데 이건 Spring에서 정의한 오래 전부터 사용한하던 validation용 annotation이고 기본 표준 annotation인 @Valid보다 좀 더 많은 기능을 제공한다.
        Member member = memberRegister.register(request);

        return MemberRegisterResponse.of(member);
    }
}
