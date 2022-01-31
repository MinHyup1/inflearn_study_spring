package hello.advanced.trace.hellotrace;

import org.springframework.stereotype.Component;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HelloTraceV1 {
	
	private static final String STAR_PREFIX = "--->";
	private static final String COMPLETE_PREFIX = "<---";
	private static final String EX_PREFIX = "<X--";
	
	
	public TraceStatus begin(String message) {
		TraceId traceId = new TraceId();
		Long statyTimeMs = System.currentTimeMillis();
		//로그 출력
		log.info("[{}] {}{}", traceId.getId(), addSpace(STAR_PREFIX, traceId.getLevel()), message);
		return new TraceStatus(traceId, statyTimeMs, message);
	}
	

	public void end(TraceStatus status) {
		complete(status, null);
	}
	
	public void exception(TraceStatus status, Exception e) {
		complete(status,e);
	}

	private void complete(TraceStatus status, Exception e) {
		
		Long stopTimeMs = System.currentTimeMillis();
		Long resultTimeMs = stopTimeMs - status.getStartTimeMs();
		TraceId traceId = status.getTraceId();
		
		if(e == null) {
			log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),resultTimeMs);
		}else {
			log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(),resultTimeMs,e.toString());
		}
	}
	
	
	//level=0
	//level=1 |--->
	//level=2 |    |--->
	
	
	//level=2 ex |    |<X-
	//level=1 ex |<X-
	private static String addSpace(String prefix, int level) {
		StringBuilder sb =new StringBuilder();
		for (int i = 0; i < level; i++) {
			sb.append((i == level - 1) ? "|" + prefix : "|   ");
		}
		
		return sb.toString();
	}
}
