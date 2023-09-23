package com.irene.ireneText.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.irene.ireneText.ExchangeRateRepository.ExchangeRateRepository;
import com.irene.ireneText.dto.RmbToNtdDto;
import com.irene.ireneText.dto.UsdToNtdDto;
import com.irene.ireneText.dto.UsdToRmbDto;
import com.irene.ireneText.model.ExchangeRateModel;

import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {
	private final ExchangeRateRepository repository;

	// 初始化
	@Autowired
	public ExchangeRateService(ExchangeRateRepository repository) {
		this.repository = repository;
	}

	public List<ExchangeRateModel> getAll() {
		// 獲取所有的匯率
		return repository.findAll();
	}

	// 找個別資料
	public ExchangeRateModel findByID(Long id) {
		ExchangeRateModel result = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("此編號" + id + "不存在"));
		return result;
//The method getById(Long) from the type JpaRepository<ExchangeRateModel,Long> is deprecated
	}

	public ExchangeRateModel createRate(ExchangeRateModel rate) {
		// 新增匯率保存到資料庫
		return repository.save(rate);
	}

	// 查美金轉台幣
	public List<UsdToNtdDto> getUsd_to_ntdRates() {
		return repository.getUsd_to_ntdRates();
	}

	// 查人民幣轉台幣
	public List<RmbToNtdDto> getRmb_to_ntdRates() {
		return repository.getRmb_to_ntdRates();
	}

	// 查美金轉人民幣
	public List<UsdToRmbDto> getUsd_to_rmbRates() {
		return repository.getUsd_to_rmbRates();
	}

	// 新增汇率数据
	public ExchangeRateModel createExchangeRate(ExchangeRateModel exchangeRateModel) {
		return repository.save(exchangeRateModel);
	}

	// 刪除匯率
	public void deleteExchangeRate(Long id) {
		repository.deleteById(id);
	}

	// 更新匯率
	public ExchangeRateModel updateExchangeRate(Long id, ExchangeRateModel updatedModel) {
		//updatedModel新值新增點，覆蓋到existingModel
		ExchangeRateModel existingModel = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("此編號" + id + "不存在"));
		
		existingModel.setDate(updatedModel.getDate());
		existingModel.setUsd_to_ntd(updatedModel.getUsd_to_ntd());
		existingModel.setAud_to_usd(updatedModel.getAud_to_usd());
		existingModel.setRmb_to_ntd(updatedModel.getRmb_to_ntd());
		existingModel.setEur_to_usd(updatedModel.getEur_to_usd());
		existingModel.setUsd_to_jpy(updatedModel.getUsd_to_jpy());
		existingModel.setGbp_to_usd(updatedModel.getGbp_to_usd());
		existingModel.setUsd_to_hkd(updatedModel.getUsd_to_hkd());
		existingModel.setUsd_to_rmb(updatedModel.getUsd_to_rmb());
		existingModel.setUsd_to_zar(updatedModel.getUsd_to_zar());
		existingModel.setNzd_to_usd(updatedModel.getNzd_to_usd());
		return repository.save(existingModel);
	}
	//
//	    // 更新汇率信息
//	    public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate) {
//	        return exchangeRateRepository.save(exchangeRate);
//	    }
//

}
