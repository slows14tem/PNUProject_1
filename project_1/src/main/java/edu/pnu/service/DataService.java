package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.DataDao;
import edu.pnu.domain.Category;
import edu.pnu.domain.Leadtime_Result_Temp;
import edu.pnu.domain.PastLeadtime;

@Service
public class DataService {
	
	@Autowired
	private DataDao dataDao;

	public List<Category> getJson(){
		return dataDao.getJson();
	}
	
	public List<Leadtime_Result_Temp> getLeadtime(Leadtime_Result_Temp leadResult){
		return dataDao.getLeadtime(leadResult);		
	}
	
	public List<PastLeadtime> getPastLeadtime(PastLeadtime original){
		return dataDao.PastLeadtime(original);
	}



}
