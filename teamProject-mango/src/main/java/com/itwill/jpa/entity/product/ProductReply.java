package com.itwill.jpa.entity.product;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.itwill.jpa.entity.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductReply {
	@Id
    @SequenceGenerator(name = "PRODUCT_REPLY_NO_SEQ",sequenceName = "PRODUCT_REPLY_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_REPLY_NO_SEQ")
	private Long productReplyId;
	
	private String productReplytTitle;
	private String productReplyContent;

    @CreationTimestamp
    private LocalDateTime creDateTime;
    
	@ManyToOne
	@JoinColumn(name = "product_no")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;	
}
