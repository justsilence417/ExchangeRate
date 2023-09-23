package com.irene.ireneText.dto;

import java.util.Date;

public class RmbToNtdDto {
	private Long id;
	private Date date;
	private Float rmb_to_ntd; //人民幣轉台幣
	
	//建構式
	public RmbToNtdDto (Long id,Date date,Float rmb_to_ntd) {
		this.id = id;
		this.date = date;		
		this.rmb_to_ntd = rmb_to_ntd;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getRmb_to_ntd() {
		return rmb_to_ntd;
	}

	public void setRmb_to_ntd(Float rmb_to_ntd) {
		this.rmb_to_ntd = rmb_to_ntd;
	}
	
	

}
