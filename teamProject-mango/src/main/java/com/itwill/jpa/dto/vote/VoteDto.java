package com.itwill.jpa.dto.vote;

import java.sql.Date;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VoteDto {

	private Long voteId;				//  투표 번호
	
	private Date voteDate; 				//  투표 날짜
	private int voteTot; 				//  투표 합산점수

	
	public VoteDto(Vote vote) {
		this.voteId = vote.getVoteId();
		this.voteDate = vote.getVoteDate();
		this.voteTot = vote.getVoteTot();
	}
	public static VoteDto toDto(Vote entity) {
		return VoteDto.builder()
					  .voteId(entity.getVoteId())
					  .voteDate(entity.getVoteDate())
					  .voteTot(entity.getVoteTot())
					  .build();
	}
	

	
	
}