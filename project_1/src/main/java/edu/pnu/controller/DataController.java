package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.AutoSearch;
import edu.pnu.domain.Category;
import edu.pnu.domain.Leadtime_Result_Temp;
import edu.pnu.domain.PastLeadtime;
import edu.pnu.service.DataService;

@RestController
public class DataController {
	
	@Autowired
	private DataService dataservice;
	
	@GetMapping("/data/search")
	public List<AutoSearch> getSearch(){
		return dataservice.getSearch();
	}
	
	@GetMapping("/data/selectlist")
	public List<Category> getJson(){
		return dataservice.getJson();
	}
	
//	@PostMapping("/data/leadtime")
//	public List<Leadtime_Result_Temp> getLeadtime(@RequestBody Leadtime_Result_Temp leadResult){
//		return dataservice.getLeadtime(leadResult);
//	}
	@GetMapping("/data/leadtime")
	public List<Leadtime_Result_Temp> getLeadtime(Leadtime_Result_Temp leadResult){
		return dataservice.getLeadtime(leadResult);
	}
	
	@GetMapping("/data/past_leadtime")
	public List<PastLeadtime> getPastLeadtime(PastLeadtime original){
		return dataservice.getPastLeadtime(original);
	}
}
