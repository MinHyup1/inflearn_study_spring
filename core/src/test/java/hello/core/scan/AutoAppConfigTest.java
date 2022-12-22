package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    //자동등록빈 vs 자동등록빈 (에러발생)
    //수동등록빈 vs 수동등록빈 (수동등록빈이 우선권을가짐, 수동빈이 자동빈을 오버라이딩 해버림.)
//    #애매한 이쁜 코드보다 길더라도 명확한 코드가 좋다
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
