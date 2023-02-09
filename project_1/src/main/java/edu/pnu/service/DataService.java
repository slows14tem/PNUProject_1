package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.DataDao;
import edu.pnu.domain.CategoryVO;
import edu.pnu.domain.LeadtimeSearchVO;
import edu.pnu.domain.LeadtimeResultVO;
import edu.pnu.domain.PastLeadtimeVO;

@Service
public class DataService {
	
	@Autowired
	private DataDao dataDao;

	public List<CategoryVO> getSelectList(){
		return dataDao.getSelectList();
	}
	
	public List<LeadtimeResultVO> getLeadtime(LeadtimeResultVO leadResult){
		return dataDao.getLeadtime(leadResult);		
	}
	
	public List<PastLeadtimeVO> getPastLeadtime(PastLeadtimeVO original){
		return dataDao.PastLeadtime(original);
	}

	public List<LeadtimeSearchVO> getSearch() {
		return dataDao.getSearch();
	}


}
