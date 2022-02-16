package hello.advanced.trace.strategy.code.strategy;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2Test {

	//전략 패턴 적용
	
	@Test
	void startegyV1() {
		ContextV2 context = new ContextV2();
		context.excute(new StrategyLogic1());
		context.excute(new StrategyLogic2());
	}
	
	//익명 내부클래스 사용
	@Test
	void startegyV2() {
		ContextV2 context = new ContextV2();
		context.excute(new Strategy() {
			
			@Override
			public void call() {
				log.info("비지니스 로직1 실행");
				
			}
		});
		context.excute(new Strategy() {
			
			@Override
			public void call() {
				log.info("비지니스 로직2 실행");
				
			}
		});
	}
	
	
	//람다 사용
	@Test
	void strategyV3() {
		ContextV2 context = new ContextV2();
		context.excute(() -> log.info("비지니스 로직1 실행"));
		context.excute(() -> log.info("비지니스 로직2 실행"));
	}
}










