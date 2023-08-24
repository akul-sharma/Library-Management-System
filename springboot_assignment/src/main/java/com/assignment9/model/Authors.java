package com.assignment9.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authors {

	@Id
    int authorId;
    
    String authorName;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
}
