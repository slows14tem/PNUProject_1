package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.LeadtimeResultVO;
import edu.pnu.domain.LogVO;
import edu.pnu.domain.PastLeadtimeVO;
//import edu.pnu.service.DataService;
import edu.pnu.service.LeadtimeService;

@RestController
public class LeadtimeController {
	
	@Autowired
//	private DataService dataservice;
	private LeadtimeService leadtimeService;
	
	//리드타임 예측 결과 출력(select page)
	@GetMapping("/data/leadtime")
	public List<LeadtimeResultVO> getLeadtime(LeadtimeResultVO leadResult){
		return leadtimeService.getLeadtime(leadResult);
	}
	
	//과거의 리드타임 정보 출력(visual page)
	@GetMapping("/data/past_leadtime")
	public List<PastLeadtimeVO> getPastLeadtime(PastLeadtimeVO original){
		return leadtimeService.getPastLeadtime(original);
	}
	
	//리드타임 예측 검색 log 저장
	@PostMapping("/data/searchlog")
	public void addLog(@RequestBody LogVO log) {
		leadtimeService.addLog(log);
	}
	
	//리드타임 예측 검색 log 출력
	@GetMapping("/data/getlog")
	public List<LogVO> getLog(){
		return leadtimeService.getLog();
	}

}
