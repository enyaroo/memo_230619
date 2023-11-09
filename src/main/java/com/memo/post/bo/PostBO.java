package com.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.post.domain.Post;
import com.memo.post.mapper.PostMapper;

@Service
public class PostBO {
	
	@Autowired
	private PostMapper postMapper;
	
	// input : userId
	// output : List<Post>
	public List<Post> getPostListByUserId(int userId) {
		return postMapper.selectPostListByUserId(userId);
	}
	
	// input : 글 번호, 글쓴이 번호
	// output : x
	public void deletePostByPostIdUserId(int postId, int userId) {
		// 기존 글 가져오기 (이미지가 있으면 삭제해야 하기 때문)
		Post post = postMapper.selectPostByPostIdUserId(postId, userId);
		if (post == null) {
			logger.info("[글 삭제] post가 null. postId:{}, userId:{}")
			return;
		}
		
		// 기존 이미지가 존재하면 -> 삭제
		if (post.getImagePath() != null) {
			fileManager.deleteFile(post.getImagePath());
		}
		
		// DB 삭제
		postMapper.
		
	}
	
}
