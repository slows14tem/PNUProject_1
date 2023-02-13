package edu.pnu.controller;

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
	
	//검색기능 구현을 위한 데이터 출력
	@GetMapping("/data/selectlist")
	public List<CategoryVO> getSelectList(){
		return dataservice.getSelectList();
	}
	
	//리드타임 예측 결과 출력(select page)
	@GetMapping("/data/leadtime")
	public List<LeadtimeResultVO> getLeadtime(LeadtimeResultVO leadResult){
		return dataservice.getLeadtime(leadResult);
	}
	
	//과거의 리드타임 정보 출력(visual page)
	@GetMapping("/data/past_leadtime")
	public List<PastLeadtimeVO> getPastLeadtime(PastLeadtimeVO original){
		return dataservice.getPastLeadtime(original);
	}
	
	//리드타임 예측 검색 log 저장
	@PostMapping("/data/searchlog")
	public void addLog(@RequestBody LogVO log) {
		dataservice.addLog(log);
	}
	
	//리드타임 예측 검색 log 출력
	@GetMapping("/data/getlog")
	public List<LogVO> getLog(){
		return dataservice.getLog();
	}
	
	//검색결과 출력(Order page)
	@GetMapping("/data/search")
	public List<LeadtimeSearchVO> getSearch(){
		return dataservice.getSearch();
	}
	
	//겸색 결과 중 선택된 리스트를 저장
	@PostMapping("/data/balju")
	public void addBalju(@RequestBody BaljuVO[] balju) {
		//@requestbody로 오는 데이터가 row하나가 아니기 때문에 []를 넣어서 배열로 선언한 것.(DAO확인)
		dataservice.addBalju(balju);
	}
	
	//저장된 리스트 출력
	@GetMapping("/data/baljulist")
	public List<BaljuVO> getBalju(){
		return dataservice.getBalju();
	}
}
