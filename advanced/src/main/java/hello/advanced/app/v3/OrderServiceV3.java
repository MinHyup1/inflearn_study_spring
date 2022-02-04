package hello.advanced.app.v3;

import org.springframework.stereotype.Service;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // lombock이 final생성자 하나로 의존성 주입
public class OrderServiceV3 {

	private final OrderRepositoryV3 orderRepository;
	private final LogTrace trace;

	public void orderItem(String itemId) {

		TraceStatus status = null;

		try {
			status = trace.begin("OrderService.orderItem()");
			orderRepository.save(status.getTraceId() ,itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}

	}

}
