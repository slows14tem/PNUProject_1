package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.CategoryVO;
//import edu.pnu.service.DataService;
import edu.pnu.service.SearchService;

@RestController
public class SearchController {
	
	@Autowired
//	private DataService dataservice;
	private SearchService searchService;
	
	//검색기능 구현을 위한 분류별 리스트 출력
	@GetMapping("/data/selectlist")
	public List<CategoryVO> getSelectList(){
		return searchService.getSelectList();
	}

}
