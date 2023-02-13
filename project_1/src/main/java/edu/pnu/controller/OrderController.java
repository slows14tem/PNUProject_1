package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.BaljuVO;
import edu.pnu.domain.LeadtimeSearchVO;
//import edu.pnu.service.DataService;
import edu.pnu.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
//	private DataService dataservice;
	private OrderService orderService;
	
	//자동완성 검색결과 출력(Order page)
	@GetMapping("/data/search")
	public List<LeadtimeSearchVO> getSearch(){
		return orderService.getSearch();
	}
	
	//겸색결과중 선택된 리스트를 저장
	@PostMapping("/data/balju")
	public void addBalju(@RequestBody BaljuVO[] balju) {
		//@requestbody로 오는 데이터가 row하나가 아니기 때문에 []를 넣어서 배열로 선언한 것.(DAO확인)
		orderService.addBalju(balju);
	}
	
	//저장된 리스트 출력
	@GetMapping("/data/baljulist")
	public List<BaljuVO> getBalju(){
		return orderService.getBalju();
	}

}
