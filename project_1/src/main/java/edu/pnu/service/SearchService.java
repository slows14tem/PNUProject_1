package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import edu.pnu.dao.DataDao;
import edu.pnu.dao.SearchDAO;
import edu.pnu.domain.CategoryVO;

@Service
public class SearchService {
	
	@Autowired
//	private DataDao dataDao;
	private SearchDAO searchDAO;
	
	public List<CategoryVO> getSelectList(){
		return searchDAO.getSelectList();
	}

}
