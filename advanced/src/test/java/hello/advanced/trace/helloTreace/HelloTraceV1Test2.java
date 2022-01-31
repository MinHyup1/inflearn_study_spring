package hello.advanced.trace.helloTreace;

import java.nio.channels.IllegalSelectorException;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;

public class HelloTraceV1Test2 {

	@Test
	void begin_end() {
		HelloTraceV2 trace =  new HelloTraceV2();
		TraceStatus status1 = trace.begin("hello");
		TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
		trace.end(status2);
		trace.end(status1);
	}
	
	@Test
	void begin_execption() {
		HelloTraceV2 trace =  new HelloTraceV2();
		TraceStatus status1 = trace.begin("hello1");
		TraceStatus status2 = trace.beginSync(status1.getTraceId(),"hello2");
		trace.exception(status2, new IllegalStateException());
		trace.exception(status1, new IllegalStateException());
	}
	
}
