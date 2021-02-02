package com.t9.octavo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "db_sequence")
public class DbSequence {
	@Id
	@Field("_id")
	private String id;
	
	@Field("seq")
	private Long seq;

	public DbSequence() {

	}

	public DbSequence(String id, Long seq) {
		this.id = id;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}
	
}
