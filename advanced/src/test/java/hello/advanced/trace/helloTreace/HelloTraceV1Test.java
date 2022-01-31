package hello.advanced.trace.helloTreace;

import java.nio.channels.IllegalSelectorException;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;

public class HelloTraceV1Test {

	@Test
	void begin_end() {
		HelloTraceV1 trace =  new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.end(status);
	}
	
	@Test
	void begin_execption() {
		HelloTraceV1 trace =  new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.exception(status, new IllegalStateException());
	}
	
}
