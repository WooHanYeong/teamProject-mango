package com.itwill.jpa.entity.order;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.order.CouponDto;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coupon")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Coupon {

	
//	/*멤버필드*/
//	
//	
	@Id
	@SequenceGenerator(name = "COUPON_COUPON_NO_SEQ",sequenceName = "COUPON_COUPON_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPON_COUPON_NO_SEQ")
//	//PK 쿠폰 번호
	private Long couponId;
//	//쿠폰 이름(ex.회원가입 쿠폰, 10월 감사제 쿠폰등)
	private String couponName;
//	
//	//1개월짜리 쿠폰, 2개월짜리 쿠폰, 12개월짜리 쿠폰 등등
	private String couponType;
//	
//	//쿠폰일련번호
	private String couponCode;
//	
//	//쿠폰 할인율
	private Double couponDiscount;
//	
//	//쿠폰 만료일
	private Date couponExpirationDate;
//	
//	//사용된 쿠폰인지 확인 여부
	private int couponIsUsed;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	// 쿠폰과 유저 n대 1
	//PK 유저 번호
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	
	// 쿠폰과 주문 n대 1
	//PK 주문 번호
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Order order;
	
	
	
	
//	/*메서드*/
	
	
	
//Dto -> entity 변환해주는 매서드
	public static Coupon toEntity(CouponDto dto) {
		//클라이언트 페이지에서 전부 관리자 권한을 가진 유저만 해당 쿠폰 DTO 데이터 입력가능(일반유저는 쿠폰정보 변경불가)
		return Coupon.builder()
				.couponId(dto.getCouponId())
				.couponName(dto.getCouponName())
				.couponType(dto.getCouponType())
				.couponCode(dto.getCouponCode())
				.couponDiscount(dto.getCouponDiscount())
				.couponExpirationDate(dto.getCouponExpirationDate())
				.couponIsUsed(dto.getCouponIsUsed())
				.order(Order.builder().orderId(dto.getOrderId()).build())
				.user(User.builder().userId(dto.getUserId()).build())
				.build();	
	}
}
	
