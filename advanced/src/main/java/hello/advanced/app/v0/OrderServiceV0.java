package hello.advanced.app.v0;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //lombock이 final생성자 하나로 의존성 주입
public class OrderServiceV0 {

	
	private final OrderRepositoryV0 orderRepository;
	
	public void orderItem(String itemId) {
		orderRepository.save(itemId);
	}
}
