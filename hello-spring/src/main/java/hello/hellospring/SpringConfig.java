package hello.hellospring;

import hello.hellospring.domain.MemberRepository;
import hello.hellospring.domain.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
*  의존성 주입(DI) 3가지 : 생성자주입, 필드주입, setter주입이 있다.
*  의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.
*
* */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return  new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
