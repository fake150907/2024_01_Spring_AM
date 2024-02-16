package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private int id;
	private int articleId;
	private String regDate;
	private String updateDate;
	private int memberId;
	private String body;
	private int goodReactionPoint;
	private int badReactionPoint;
	private String extra__writer;

}
