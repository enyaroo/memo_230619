package com.memo.post.domain;

import java.time.ZonedDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data // getter, setter
public class Post {
	private int id;
	private int userId;
	private String subject;
	private String imagePath;
	private String content;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
}
