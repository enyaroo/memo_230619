package com.memo.post;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {
	
	@PostMapping("/create")
	public Map<String, Object> create() {
		return result;
	}
	
	@PutMapping("/update")
	public Map<String, Object> update() {
		return result;
	}
	
	@DeleteMapping("/delete")
	public Map<String, Object> delete(
			@RequestParam("postId") int userId
			, HttpSession session) {
		
		int userId = (int)session.getAttribute("userId");
		
		// db delete
		
		// 응답값
		
		return result;
	}
}
