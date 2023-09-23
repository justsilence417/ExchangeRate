package com.irene.ireneText.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irene.ireneText.dto.RmbToNtdDto;
import com.irene.ireneText.dto.UsdToNtdDto;
import com.irene.ireneText.dto.UsdToRmbDto;
import com.irene.ireneText.model.ExchangeRateModel;
import com.irene.ireneText.service.ExchangeRateService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EachangeRateController {

	@Autowired
	private ExchangeRateService exchangeRateService;

	// 測試是否有跟資料庫連線成功
	@GetMapping("/")
	public String home() {
		System.out.println("hello");
		return "hello java";
	}

	// 查詢所有匯率
	@GetMapping("/all")
	public List<ExchangeRateModel> getAll() {
		return exchangeRateService.getAll();
	}

	// 查詢個別id
	@GetMapping("/findId/{id}")
	public ExchangeRateModel findByID(@PathVariable Long id) {
		return exchangeRateService.findByID(id);
	}

	// 查詢美金換台幣匯率
	@GetMapping("/usd_to_ntd")
	public List<UsdToNtdDto> getUsdToNtdRates() {
		return exchangeRateService.getUsd_to_ntdRates();
	}

	// 查人民幣轉台幣匯率
	@GetMapping("/rmb_to_ntd")
	public List<RmbToNtdDto> getRmb_to_ntdRates() {
		return exchangeRateService.getRmb_to_ntdRates();
	}

	// 查美金轉人民幣匯率
	@GetMapping("/usd_to_rmb")
	public List<UsdToRmbDto> getUsd_to_rmbRates() {
		return exchangeRateService.getUsd_to_rmbRates();
	}

	// 新增匯率
	// 後臺看到的是全部匯率欄位資料
	// @PostMapping("/addRates")
	// public ExchangeRateModel exchangeRateModel(@RequestBody ExchangeRateModel
	// exchangeRateModel){
	// return exchangeRateService.createExchangeRate(exchangeRateModel);
	// }

	// ResponseEnity方法，後台可以直接看到新增的第幾筆資料與匯率
	@PostMapping("/addRates")
	public ResponseEntity<Map<String, Object>> createExchangeRate(@RequestBody ExchangeRateModel exchangeRateModel) {
		ExchangeRateModel saveRates = exchangeRateService.createExchangeRate(exchangeRateModel);
//		return ResponseEntity.ok(saveRates.getId() + "save ok ");
		 Map<String, Object> response = new HashMap<>();
		    response.put("success", true);
		    response.put("message", "匯率資料已成功新增！");
		    return ResponseEntity.ok(response);
	}

	// 刪除匯率
	@DeleteMapping("/deleteRates/{id}")
	public ResponseEntity<String> deleteExchangeRate(@PathVariable Long id) {
		exchangeRateService.deleteExchangeRate(id);
		return ResponseEntity.ok(id + "delect ok ");
	}

	// 更新匯率
	@PutMapping("/updateRates/{id}")
	public ResponseEntity<ExchangeRateModel> updateExchangeRate(@PathVariable Long id,
			@RequestBody ExchangeRateModel updatedModel) {
		ExchangeRateModel updaterate = exchangeRateService.updateExchangeRate(id, updatedModel);
		return ResponseEntity.ok(updaterate);
	}

}
