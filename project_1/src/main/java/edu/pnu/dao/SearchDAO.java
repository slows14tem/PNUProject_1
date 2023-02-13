package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.CategoryVO;

@Repository
public class SearchDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CategoryVO> getSelectList() {
		String sql = "SELECT * "
				+ "FROM leadtime_final";
		List<CategoryVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<CategoryVO>(CategoryVO.class));
		return list;
	}

}
