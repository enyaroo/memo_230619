package com.memo.post.bo;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.post.domain.Post;
import com.memo.post.mapper.PostMapper;

@Service
public class PostBO {
	
	private static final int POST_MAX_SIZE = 3;
	
	@Autowired
	private PostMapper postMapper;
	
	// input : userId
	// output : List<Post>
	public List<Post> getPostListByUserId(int userId, Integer prevId, Integer nextId) {
		// 게시글 번호 : 10 9 8 | 7 6 5 | 4 3 2 | 1
		// 만약 4 3 2 페이지에 있을 때
		// 1) 다음 : 2보다 작은 3개 desc정렬
		// 2) 이전 : 4보다 큰 3개 asc정렬 (5 6 7) => List reverse(7 6 5)
		// 3) 첫 페이지 : 이전, 다음 없음 desc 3개
		
		String direction = null; // 방향
		Integer standardId = null; // 기준 postId
		if (prevId != null) { // 이전
			direction = "prev";
			standardId = prevId;
			
			List<Post> postList = postMapper.selectPostListByUserId(prevId, direction, standardId, POST_MAX_SIZE);
			
			// reverse	5 6 7 => 7 6 5
			Collections.reverse(postList); // 뒤집고 저장
			return postList;
		} else if (nextId != null) { // 다음
			direction = "next";
			standardId = nextId;
		}
		
		// 첫 페이지 or 다음
		return postMapper.selectPostListByUserId(userId, direction, standardId, POST_MAX_SIZE);
	}
	
	// 이전 페이지의 마지막인가?
	public boolean isPrevLastPageByUserId(int prevId, int userId) {
		int postId = postMapper.selectPostIdbyUserIdAndSort(userId, "DESC");
		return postId == prevId; // 같으면 끝 true, 아니면 false
	}
	
	// 다음 페이지의 마지막인가?
	public boolean isNextLastPageByUserId(int nextId, int userId) {
		int postId = postMapper.selectPostIdbyUserIdAndSort(userId, "ASC");
		return postId == nextId;
	}
	
	// input : 글 번호, 글쓴이 번호
	// output : x
//	public void deletePostByPostIdUserId(int postId, int userId) {
//		// 기존 글 가져오기 (이미지가 있으면 삭제해야 하기 때문)
//		Post post = postMapper.selectPostByPostIdUserId(postId, userId);
//		if (post == null) {
//			logger.info("[글 삭제] post가 null. postId:{}, userId:{}")
//			return;
//		}
//		
//		// 기존 이미지가 존재하면 -> 삭제
//		if (post.getImagePath() != null) {
//			fileManager.deleteFile(post.getImagePath());
//		}
//		
//		// DB 삭제
//		postMapper.
//		
//	}
//	
}
