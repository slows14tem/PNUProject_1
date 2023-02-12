package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.DataDao;
import edu.pnu.domain.BaljuVO;
import edu.pnu.domain.CategoryVO;
import edu.pnu.domain.LeadtimeSearchVO;
import edu.pnu.domain.LogVO;
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
	
	public void addLog(LogVO log) {
		dataDao.addLog(log);
	}

	public List<LogVO> getLog() {
		return dataDao.getLog();
	}

	public List<LeadtimeSearchVO> getSearch() {
		return dataDao.getSearch();
	}

	public void addBalju(BaljuVO[] balju) {
		dataDao.addBalju(balju);
		
	}

	public List<BaljuVO> getBalju() {
		return dataDao.getBalju();
	}


}
