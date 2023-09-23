package com.irene.ireneText.ExchangeRateRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irene.ireneText.dto.RmbToNtdDto;
import com.irene.ireneText.dto.UsdToNtdDto;
import com.irene.ireneText.dto.UsdToRmbDto;
import com.irene.ireneText.model.ExchangeRateModel;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateModel, Long> {

	// 查美金轉台幣
	@Query("SELECT new com.irene.ireneText.dto.UsdToNtdDto(id,date,usd_to_ntd)FROM ExchangeRateModel")
	List<UsdToNtdDto> getUsd_to_ntdRates();

	// 查人民幣轉台幣
	@Query("SELECT new com.irene.ireneText.dto.RmbToNtdDto(id,date,rmb_to_ntd)FROM ExchangeRateModel")
	List<RmbToNtdDto> getRmb_to_ntdRates();

	// 查美金轉人民幣
	@Query("SELECT new com.irene.ireneText.dto.UsdToRmbDto(id,date,usd_to_rmb)FROM ExchangeRateModel")
	List<UsdToRmbDto> getUsd_to_rmbRates();
}
