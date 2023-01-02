package hello.core;

import hello.core.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

	private OrderService oderService;

	@Autowired
	public CoreApplicationTests(OrderService oderService) {
		this.oderService = oderService;
	}

	@Test
	void contextLoads() {
	}

}
