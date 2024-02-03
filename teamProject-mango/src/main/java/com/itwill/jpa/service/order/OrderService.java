package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.dto.order.OrderDto;

public interface OrderService {
	//주문 생성
	OrderDto saveOrder(OrderDto orderDto);
	//주문 정보 수정
	OrderDto updateOrder(OrderDto orderDto) throws Exception;
	//주문 한개 삭제
	OrderDto deleteOrder(Long orderId) throws Exception;
	//주문 전체 삭제
	List<OrderDto> deleteAllOrder() throws Exception;
	//유저 Id로 전체 주문 불러오기
	List<OrderDto> ordersByUserId(String UserId);
	//전체 주문 불러오기(관리자)
	List<OrderDto> orders();
	//주문 최신순으로 나열하기
	List<OrderDto> orderListByNewer(String userId);
	//주문 오래된순으로 나열하기
	List<OrderDto> orderListByOlder(String userId);
	//유저의 아이템 정보를 가져와서 주문 총금액 계산
	double calculateTotalOrderPrice(String userId);
	//유저의 멤버쉽 구매 정보 저장 서비스
	boolean isMembershipPurchasedAndSaveMembership(String userId);
	//유저의 멤버쉽 구매 로직 (멤버쉽 결제가 성공하면 반환값 true)
	boolean performMembershipPurchaseLogic(String userId);
}
