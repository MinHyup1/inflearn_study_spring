package hello.advanced.app.v2;

import org.springframework.stereotype.Service;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // lombock이 final생성자 하나로 의존성 주입
public class OrderServiceV2 {

	private final OrderRepositoryV2 orderRepository;
	private final HelloTraceV2 trace;

	public void orderItem(TraceId traceId, String itemId) {

		TraceStatus status = null;

		try {
			status = trace.beginSync(traceId,"OrderService.orderItem()");
			orderRepository.save(status.getTraceId() ,itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e; // 예외를 꼭 다시 던져주어야 한다.
		}

	}

}
