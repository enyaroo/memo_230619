package com.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.user.entity.UserEntity;
import com.memo.user.repository.UserRepository;

@Service
public class UserBO {
	
	@Autowired
	private UserRepository userRepository;
	
	// input : loginId, password
	// output : UserEntity (null or entity)
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
	}
}
