package com.memo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memo.common.EncryptUtils;
import com.memo.user.bo.UserBO;
import com.memo.user.entity.UserEntity;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
//	@RequestMapping("/is-duplicated-id")
//	public Map<String, Object> isDuplicatedId() {
//		return result;
//	}
	
//	@PostMapping("/sign-up")
//	public Map<String, Object> signUp() {
//		return result;
//	}
	
	@PostMapping("/sign-in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		
		// 비밀번호 hashing
		String hashedPassword = EncryptUtils.md5(password);
		
		// db 조회 (loginId, 해싱된 비밀번호) => null or 있음
		UserEntity user = userBO.getUserEntityByLoginIdPassword(loginId, hashedPassword);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			// 로그인 처리
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userLoginId", user.getLoginId());
			
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			// 로그인 불가
			result.put("code", 500);
			result.put("errorMessage", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}
	
}
