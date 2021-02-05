package com.t9.octavo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "db_sequence")
public class DbSequence {
	@Id
	@Field("_id")
	private String id;
	
	@Field("seqcD")
	private Long seqcD;
	
	@Field("seqdE")
	private Long seqdE;
	
	@Field("seqgR")
	private Long seqgR;
	
	@Field("seqnC")
	private Long seqnC;
	
	@Field("seqtN")
	private Long seqtN;

	public DbSequence() {

	}

	public DbSequence(String id, Long seqcD, Long seqdE, Long seqgR, Long seqnC, Long seqtN) {
		this.id = id;
		this.seqcD = seqcD;
		this.seqdE = seqdE;
		this.seqgR = seqgR;
		this.seqnC = seqnC;
		this.seqtN = seqtN;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSeqcD() {
		return seqcD;
	}

	public void setSeqcD(Long seqcD) {
		this.seqcD = seqcD;
	}

	public Long getSeqdE() {
		return seqdE;
	}

	public void setSeqdE(Long seqdE) {
		this.seqdE = seqdE;
	}

	public Long getSeqgR() {
		return seqgR;
	}

	public void setSeqgR(Long seqgR) {
		this.seqgR = seqgR;
	}

	public Long getSeqnC() {
		return seqnC;
	}

	public void setSeqnC(Long seqnC) {
		this.seqnC = seqnC;
	}

	public Long getSeqtN() {
		return seqtN;
	}

	public void setSeqtN(Long seqtN) {
		this.seqtN = seqtN;
	}

	
	
}
