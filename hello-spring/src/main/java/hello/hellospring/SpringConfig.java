package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
*  의존성 주입(DI) 3가지 : 생성자주입, 필드주입, setter주입이 있다.
*  의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.
*
* */
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return  new MemberService(memberRepository());
    }

//        개방-폐쇄 원칙(OCP, Open-Closed Principle)
//        - 확장에는 열려있고, 수정, 변경에는 닫혀있다.
//        객체지향 설계의 장점 : 다형성을 활용할 수 있다(인터페이스를 바꿔끼우기 가능) DI덕분에 굉장히 편하게 다형성 활용 가능
//        스프링의 DI(Dependencies Injection)을 사용하면 기존코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경 할 수 있다.
    @Bean
    public MemberRepository memberRepository() {
//        return new MemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
