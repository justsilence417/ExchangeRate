package com.irene.ireneText.dto;

import java.util.Date;

public class UsdToRmbDto {
	private Long id;
	private Date date;
	private Float usd_to_rmb; //美金轉人民幣
	
	//建構式
	public UsdToRmbDto (Long id,Date date,Float usd_to_rmb) {
		this.id = id;
		this.date = date;
		this.usd_to_rmb = usd_to_rmb;		
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

	public Float getUsd_to_rmb() {
		return usd_to_rmb;
	}

	public void setUsd_to_rmb(Float usd_to_rmb) {
		this.usd_to_rmb = usd_to_rmb;
	}


}
