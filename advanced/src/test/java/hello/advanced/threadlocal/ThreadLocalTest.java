package hello.advanced.threadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.threadlocal.code.FieldService;
import hello.advanced.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalTest {

	private ThreadLocalService service = new ThreadLocalService();
	
	@Test
	void field() {
		
		/*
		 * Runnable userA = new Runnable() {
		 * 
		 * @Override public void run() { fieldService.logic("userA") } }
		 */
		//람다 사용
		log.info("main start");
		Runnable userA = () -> {
			service.logic("userA");
		};
		
		log.info("main start");
		Runnable userB = () -> {
			service.logic("userB");
		};
		
		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");
		
		threadA.start();
		//sleep(2000); //동시성 문제 발생X
		sleep(100); // 동시성 문제 발생O
		threadB.start();
		
		sleep(2000); //메인 쓰레드 종료 대기
		log.info("main exit");
		
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
