package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.LeadtimeResultVO;
import edu.pnu.domain.LogVO;
import edu.pnu.domain.PastLeadtimeVO;

@Repository
public class LeadtimeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<LeadtimeResultVO> getLeadtime(LeadtimeResultVO leadResult) {
		String sql = "SELECT * "
				+ "FROM leadtime_final "
				+ "WHERE machinery = '%s' and items = '%s' and part1 = '%s'";
		String sqlString = String.format(sql, leadResult.getMachinery(), leadResult.getItems(), leadResult.getPart1());
		List<LeadtimeResultVO> list = jdbcTemplate.query(sqlString, 
				new BeanPropertyRowMapper<LeadtimeResultVO>(LeadtimeResultVO.class));
		return list;
	}
	
	public List<PastLeadtimeVO> getPastLeadtime(PastLeadtimeVO original) {
		String sql = "SELECT * "
				+ "FROM original "
				+ "WHERE machinery = '%s' and items = '%s' and part1 = '%s' "
				+ "GROUP BY balju";
		String sqlString = String.format(sql, original.getMachinery(), original.getItems(), original.getPart1());
		List<PastLeadtimeVO> list = jdbcTemplate.query(sqlString, 
				new BeanPropertyRowMapper<PastLeadtimeVO>(PastLeadtimeVO.class));
		return list;
	}
	
	public void addLog(LogVO log) {
		String sql = "INSERT INTO search_log (machinery, items, part1) "
				+ "VALUES (?,?,?)";
		try {
			jdbcTemplate.update(sql, log.getMachinery(), log.getItems(), log.getPart1());
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
	}

	public List<LogVO> getLog() {
		String sql = "SELECT * "
				+ "FROM search_log";
		List<LogVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<LogVO>(LogVO.class));
		return list;
	}

}
