package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.CategoryVO;
import edu.pnu.domain.LeadtimeSearchVO;
import edu.pnu.domain.LeadtimeResultVO;
import edu.pnu.domain.PastLeadtimeVO;

@Repository
public class DataDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CategoryVO> getSelectList() {
		String sql = "SELECT * "
				+ "FROM original "
				+ "ORDER BY baljucheo, machinery, items, part1";
		List<CategoryVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<CategoryVO>(CategoryVO.class));
		return list;
	}
	
	public List<LeadtimeSearchVO> getSearch() {
		String sql = "SELECT * "
				+ "FROM leadtime_final";
		List<LeadtimeSearchVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<LeadtimeSearchVO>(LeadtimeSearchVO.class));
		return list;
	}

	public List<LeadtimeResultVO> getLeadtime(LeadtimeResultVO leadResult) {
		String sql = "SELECT * "
				+ "FROM leadtime_final "
				+ "WHERE machinery = '%s' and items = '%s' and part1 = '%s'";
		String sqlString = String.format(sql, leadResult.getMachinery(), leadResult.getItems(), leadResult.getPart1());
		List<LeadtimeResultVO> list = jdbcTemplate.query(sqlString, 
				new BeanPropertyRowMapper<LeadtimeResultVO>(LeadtimeResultVO.class));
		return list;
	}

	public List<PastLeadtimeVO> PastLeadtime(PastLeadtimeVO original) {
		String sql = "SELECT * "
				+ "FROM original "
				+ "WHERE machinery = '%s' and items = '%s' and part1 = '%s' "
				+ "GROUP BY balju";
		String sqlString = String.format(sql, original.getMachinery(), original.getItems(), original.getPart1());
		List<PastLeadtimeVO> list = jdbcTemplate.query(sqlString, 
				new BeanPropertyRowMapper<PastLeadtimeVO>(PastLeadtimeVO.class));
		return list;
	}
	
}
