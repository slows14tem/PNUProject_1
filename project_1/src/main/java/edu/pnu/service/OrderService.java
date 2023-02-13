package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import edu.pnu.dao.DataDao;
import edu.pnu.dao.OrderDAO;
import edu.pnu.domain.BaljuVO;
import edu.pnu.domain.LeadtimeSearchVO;

@Service
public class OrderService {
	
	@Autowired
//	private DataDao dataDao;
	private OrderDAO orderDAO;
	
	public List<LeadtimeSearchVO> getSearch() {
		return orderDAO.getSearch();
	}

	public void addBalju(BaljuVO[] balju) {
		orderDAO.addBalju(balju);
		
	}

	public List<BaljuVO> getBalju() {
		return orderDAO.getBalju();
	}

}
