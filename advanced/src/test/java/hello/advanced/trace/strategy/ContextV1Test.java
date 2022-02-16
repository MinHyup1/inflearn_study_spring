package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {
	
	@Test
	void strategyV0() {
		logic1();
		logic2();
	}

	private void logic1() {
		long startTime = System.currentTimeMillis();
		//비지니스 로직 실행
		log.info("비지니스 로직1 실행");
		//비지니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}" , resultTime);
	}
	
	private void logic2() {
		long startTime = System.currentTimeMillis();
		//비지니스 로직 실행
		log.info("비지니스 로직2 실행");
		//비지니스 로직 종료
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime={}" , resultTime);
	}
	
	
	/*
	 * 
	 *  
	 *  전략 패턴 사용
	 *  
	 *   
	 *   */
	
	@Test
	void strategyV1() {
		StrategyLogic1 strategyLogic1 = new StrategyLogic1();
		ContextV1 context1 = new ContextV1(strategyLogic1);
		context1.excute();
		
		StrategyLogic2 strategyLogic2 = new StrategyLogic2();
		ContextV1 context2 = new ContextV1(strategyLogic2);
		context2.excute();
	}
	
	@Test //익명 내부 클래스 사용
	void strategyV2() {
		Strategy strategyLogic1 = new Strategy() {
			
			@Override
			public void call() {
				log.info("비지니스 로직1 실행");
				
			}
		};
		ContextV1 context1 =  new ContextV1(strategyLogic1);
		context1.excute();
		
		Strategy strategyLogic2 = new Strategy() {
			
			@Override
			public void call() {
				log.info("비지니스 로직2 실행");
				
			}
		};
		ContextV1 context2 =  new ContextV1(strategyLogic2);
		context2.excute();
	}
	
	
	@Test //익명 내부클래스를 더 편하게 사용해보자
	void strategyV3() {

		ContextV1 context1 =  new ContextV1(new Strategy() {
			@Override
			public void call() {
				log.info("비지니스 로직1 실행");
				}
			});
		context1.excute();
		
		ContextV1 context2 =  new ContextV1(new Strategy() {
			@Override
			public void call() {
				log.info("비지니스 로직2 실행");
				}
			});
		context2.excute();
	}
	
	@Test //람다를 사용해 더 간편하게 해보자 람다를 사용하려면 인터페이스에 메서드가 1개만 있어야함.
	void strategyV4() {
		ContextV1 context1 = new ContextV1(() -> log.info("비지니스 로직 1 실행"));
		context1.excute();
		
		ContextV1 context2 =  new ContextV1(() -> log.info("비지니스 로직 2 실행"));
		context2.excute();
	}
}
