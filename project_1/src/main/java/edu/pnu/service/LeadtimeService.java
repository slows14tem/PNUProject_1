package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import edu.pnu.dao.DataDao;
import edu.pnu.dao.LeadtimeDAO;
import edu.pnu.domain.LeadtimeResultVO;
import edu.pnu.domain.LogVO;
import edu.pnu.domain.PastLeadtimeVO;

@Service
public class LeadtimeService {
	
	@Autowired
//	private DataDao dataDao;
	private LeadtimeDAO leadtimeDAO;
	
	public List<LeadtimeResultVO> getLeadtime(LeadtimeResultVO leadResult){
		return leadtimeDAO.getLeadtime(leadResult);		
	}
	
	public List<PastLeadtimeVO> getPastLeadtime(PastLeadtimeVO original){
		return leadtimeDAO.getPastLeadtime(original);
	}
	
	public void addLog(LogVO log) {
		leadtimeDAO.addLog(log);
	}

	public List<LogVO> getLog() {
		return leadtimeDAO.getLog();
	}

}
