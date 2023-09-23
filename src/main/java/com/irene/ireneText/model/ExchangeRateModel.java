package com.irene.ireneText.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exchangerates") // 資料表名稱
public class ExchangeRateModel {
	//已經在這初始化過欄位，那在ExchangeRateRepository就不用寫public List<ExchangeRateModel> findByUsdToNtdIsNotNull();
	//因Spring Data JPA的命名，
	//它能夠根據属性名稱和方法的命名自動生成查询，這大大簡化了數據層的編碼工作。
	//若要查詢特定欄位另外新增dto

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//設主鍵
	private Long id;
	private Date date;
	private Float usd_to_ntd; //美金轉台幣
	private Float rmb_to_ntd; //人民幣轉台幣
	private Float eur_to_usd; //歐元轉美金
	private Float usd_to_jpy; //美元轉日幣
	private Float gbp_to_usd; //英鎊轉美金
	private Float aud_to_usd; //澳幣轉美金
	private Float usd_to_hkd; //美金轉港幣
	private Float usd_to_rmb; //美金轉人名幣
	private Float usd_to_zar; //美金轉南非蘭特
	private Float nzd_to_usd; //紐西蘭幣轉美元
	
	
	
	
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
	public Float getUsd_to_ntd() {
		return usd_to_ntd;
	}
	public void setUsd_to_ntd(Float usd_to_ntd) {
		this.usd_to_ntd = usd_to_ntd;
	}
	public Float getRmb_to_ntd() {
		return rmb_to_ntd;
	}
	public void setRmb_to_ntd(Float rmb_to_ntd) {
		this.rmb_to_ntd = rmb_to_ntd;
	}
	public Float getEur_to_usd() {
		return eur_to_usd;
	}
	public void setEur_to_usd(Float eur_to_usd) {
		this.eur_to_usd = eur_to_usd;
	}
	public Float getUsd_to_jpy() {
		return usd_to_jpy;
	}
	public void setUsd_to_jpy(Float usd_to_jpy) {
		this.usd_to_jpy = usd_to_jpy;
	}
	public Float getGbp_to_usd() {
		return gbp_to_usd;
	}
	public void setGbp_to_usd(Float gbp_to_usd) {
		this.gbp_to_usd = gbp_to_usd;
	}
	public Float getAud_to_usd() {
		return aud_to_usd;
	}
	public void setAud_to_usd(Float aud_to_usd) {
		this.aud_to_usd = aud_to_usd;
	}
	public Float getUsd_to_hkd() {
		return usd_to_hkd;
	}
	public void setUsd_to_hkd(Float usd_to_hkd) {
		this.usd_to_hkd = usd_to_hkd;
	}
	public Float getUsd_to_rmb() {
		return usd_to_rmb;
	}
	public void setUsd_to_rmb(Float usd_to_rmb) {
		this.usd_to_rmb = usd_to_rmb;
	}
	public Float getUsd_to_zar() {
		return usd_to_zar;
	}
	public void setUsd_to_zar(Float usd_to_zar) {
		this.usd_to_zar = usd_to_zar;
	}
	public Float getNzd_to_usd() {
		return nzd_to_usd;
	}
	public void setNzd_to_usd(Float nzd_to_usd) {
		this.nzd_to_usd = nzd_to_usd;
	}
	
	

}
