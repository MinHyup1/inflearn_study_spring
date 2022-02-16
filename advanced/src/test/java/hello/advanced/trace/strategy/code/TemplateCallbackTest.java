package hello.advanced.trace.strategy.code;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallbackTest {

	
	/*
	 * 템플릿 콜백 패턴 - 익명 내부 클래스
	 */	
	
	@Test
	void callbackV1() {
		TimeLogTemplate template = new TimeLogTemplate();
		template.excute(new Callback() {

			@Override
			public void call() {
				log.info("비지니스 로직1 실행");
			}
			
		});
		
		template.excute(new Callback() {
			
			@Override
			public void call() {
				log.info("비지니스 로직2 실행");
			}
		});
		
		
	}
	
	//람다 적용
	@Test
	void callbackV2() {
		TimeLogTemplate template = new TimeLogTemplate();
		template.excute(()->log.info("비지니스 로직1 실행"));
		
		template.excute(()->log.info("비지니스 로직2 실행"));
		
		
	}
}
