package com.itwill.jpa.entity.user;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardReply;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.product.ProductReply;
import com.itwill.jpa.entity.vote.Vote;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "userinfo")
@Table(name = "userinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	private String userId; // 회원 아이디

	@Column(length = 10, nullable = false)
	private String userPw; // 회원 비밀번호

	private String userName; // 회원 이름

	@Column(length = 15, nullable = false)
	private String userPhone; // 회원 전화번호

	private String userAddress; // 회원 주소
	private String userEmail; // 회원 이메일
	private String userJumin; // 회원 주민번호
	private String userGender; // 회원 성별
	private boolean membership;// 멤버쉽 정보
	
	public static User toEntity(UserDto dto) {
		return User.builder()
				   .userId(dto.getUserId())
				   .userPw(dto.getUserPw())
				   .userName(dto.getUserName())
				   .userPhone(dto.getUserPhone())
				   .userAddress(dto.getUserAddress())
				   .userEmail(dto.getUserEmail())
				   .userJumin(dto.getUserJumin())
				   .userGender(dto.getUserGender())
				   .membership(dto.getMemberShip())
				   .build();
	}
	
	
	//1대N 관계설정
	@ManyToOne
	@JoinColumn(name = "vote_id")
	@ToString.Exclude
	private Vote vote;



	// user와 order 1대N 관계설정
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Order> orders = new ArrayList<>();

	// user와 coupon 1대N 관계설정
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Coupon> coupons = new ArrayList<>();
	
	// user와 delivery 1대N 관계설정 
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Delivery> deliverys = new ArrayList<>();

	// user와 board_Reply 1대N 관계설정
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<BoardReply> boardReply = new ArrayList<>();
	
	// user와 product_Reply 1대N 관계설정
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<ProductReply> productReply = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Board> Board = new ArrayList<>();
	

}