package edu.pnu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.AutoSearch;
import edu.pnu.domain.Category;
import edu.pnu.domain.Leadtime_Result_Temp;
import edu.pnu.domain.PastLeadtime;

@Repository
public class DataDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<Category> getJson() {
		String sql = "SELECT machinery, items, part1 "
				+ "from category";
		List<Category> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<Category>(Category.class));
		return list;
	}

	public List<Leadtime_Result_Temp> getLeadtime(Leadtime_Result_Temp leadResult) {
		String sql = "SELECT machinery, items, part1, avg_leadtime, stdev_leadtime "
				+ "FROM leadtime_result_temp "
				+ "WHERE machinery = '%s' and items = '%s' and part1 = '%s'";
		String sqlString = String.format(sql, leadResult.getMachinery(), leadResult.getItems(), leadResult.getPart1());
		List<Leadtime_Result_Temp> list = jdbcTemplate.query(sqlString, 
				new BeanPropertyRowMapper<Leadtime_Result_Temp>(Leadtime_Result_Temp.class));
		return list;
	}

	public List<PastLeadtime> PastLeadtime(PastLeadtime original) {
		String sql = "SELECT * "
				+ "FROM original "
				+ "WHERE machinery = '%s' and items = '%s' and part1 = '%s' "
				+ "GROUP BY balju";
		String sqlString = String.format(sql, original.getMachinery(), original.getItems(), original.getPart1());
		List<PastLeadtime> list = jdbcTemplate.query(sqlString, 
				new BeanPropertyRowMapper<PastLeadtime>(PastLeadtime.class));
		return list;
	}

	public List<AutoSearch> getSearch() {
		String sql = "SELECT * "
				+ "FROM leadtime_rmse_23";
		List<AutoSearch> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<AutoSearch>(AutoSearch.class));
		return list;
	}
	
}
