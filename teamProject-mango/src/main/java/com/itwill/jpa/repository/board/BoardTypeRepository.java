package com.itwill.jpa.repository.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.board.BoardType;

public interface BoardTypeRepository extends JpaRepository<BoardType,Long >{

    List<BoardType> findAllByOrderByTypeIdAsc();
}
