package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BaljuVO;
import edu.pnu.domain.CategoryVO;
import edu.pnu.domain.LeadtimeResultVO;
import edu.pnu.domain.LeadtimeSearchVO;
import edu.pnu.domain.LogVO;
import edu.pnu.domain.PastLeadtimeVO;
import edu.pnu.service.DataService;

@RestController
public class DataController {
	
	@Autowired
	private DataService dataservice;
	

	@GetMapping("/data/selectlist")
	public List<CategoryVO> getSelectList(){
		return dataservice.getSelectList();
	}

	@GetMapping("/data/leadtime")
	public List<LeadtimeResultVO> getLeadtime(LeadtimeResultVO leadResult){
		return dataservice.getLeadtime(leadResult);
	}
	
	@GetMapping("/data/past_leadtime")
	public List<PastLeadtimeVO> getPastLeadtime(PastLeadtimeVO original){
		return dataservice.getPastLeadtime(original);
	}
	
	@GetMapping("/data/search")
	public List<LeadtimeSearchVO> getSearch(){
		return dataservice.getSearch();
	}
	
	@PostMapping("/data/searchlog")
	public void addLog(@RequestBody LogVO log) {
		dataservice.addLog(log);
	}
	
	@GetMapping("/data/getlog")
	public List<LogVO> getLog(){
		return dataservice.getLog();
	}
	
	@PostMapping("/data/balju")
	public void addBalju(@RequestBody BaljuVO[] balju) {
		//@requestbody로 오는 데이터가 row하나가 아니기 때문에 []를 넣어서 배열로 선언한 것.(DAO확인)
		dataservice.addBalju(balju);
	}
	
	@GetMapping("data/baljulist")
	public List<BaljuVO> getBalju(){
		return dataservice.getBalju();
	}
}
