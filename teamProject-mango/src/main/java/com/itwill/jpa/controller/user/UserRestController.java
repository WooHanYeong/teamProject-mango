
package com.itwill.jpa.controller.user;

import java.net.http.HttpHeaders;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.dto.user.UserLoginDto;
import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.service.user.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.models.media.MediaType;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Operation(summary = "회원가입")
	@PostMapping(value = "/join", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> userCreate(@RequestBody UserDto userDto) {
		   try {
		        if (userService.existsById(userDto.getUserId())) {
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 존재하는 아이디입니다.");
		        }

		        UserDto createdUser = new UserDto();
		        createdUser.setUserId(userDto.getUserId());
		        createdUser.setUserPw(userDto.getUserPw());

		        userService.createUser(createdUser);

		        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패: " + e.getMessage());
		    }
		}

	@Operation(summary = "로그인")
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> userLogin(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
		 try {
		        User user = userService.findUser(userLoginDto.getUserId());
		        if (user != null && user.getUserPw().equals(userLoginDto.getUserPw())) {
		            session.setAttribute("sUserId", userLoginDto.getUserId());
		            return ResponseEntity.status(HttpStatus.OK).build();
		        } else {
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
		        }
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		    }
		}

	@Operation(summary = "회원상세보기")
	@GetMapping(value = "/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> userView(@PathVariable(name = "userId") String userId, HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null || !sUserId.equals(userId)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(" 권한이 없습니다.");
		}

		User user = userService.findUser(userId);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	 @Operation(summary = "회원리스트")
	 @GetMapping("/")
	    public ResponseEntity<List<UserDto>> getAllUsers() throws Exception {
	        List<UserDto> users = userService.findUserList();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

	@Operation(summary = "회원업데이트")
	@PutMapping(value = "/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<UserUpdateDto> updateUser(@PathVariable String userId, @RequestBody UserUpdateDto userUpdateDto) {
	    try {
	        UserUpdateDto updatedUser = userService.updateUser(userUpdateDto);
	        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}

	@Operation(summary = "회원탈퇴")
	@DeleteMapping(value = "/{userId}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

	@Operation(summary = "로그아웃")
	@GetMapping(value = "/logout", produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// 아이디 중복 체크 API
	@Operation(summary = "아이디중복체크")
    @GetMapping("/{userId}")
    public ResponseEntity<Boolean> checkUserIdExists(@PathVariable String userId) throws Exception {
        boolean exists = userService.existsById(userId);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    // 아이디, 이메일로 아이디 찾기 API
    @GetMapping("/find-id")
    public ResponseEntity<String> findUserIdByUserNameUserEmail(@RequestParam(name = "user_name") String userName, @RequestParam(name = "user_email") String userEmail) {
        try {
            String foundUserId = userService.findUserIdByUserNameUserEmail(userName, userEmail);
            return new ResponseEntity<>(foundUserId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 아이디, 전화번호로 비밀번호 찾기 API
    @GetMapping("/find-pw")
    public ResponseEntity<String> findUserPwByUserIdUserPhone(@RequestParam(name = "userId") String userId, @RequestParam(name = "user_phone") String userPhone) {
        try {
            String foundUserPw = userService.findUserPwByUserIdUserPhone(userId, userPhone);
            return new ResponseEntity<>(foundUserPw, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

