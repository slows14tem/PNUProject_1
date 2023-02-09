package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.CategoryVO;
import edu.pnu.domain.LeadtimeSearchVO;
import edu.pnu.domain.LeadtimeResultVO;
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
}
