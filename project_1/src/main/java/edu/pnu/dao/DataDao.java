package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.BaljuVO;
import edu.pnu.domain.CategoryVO;
import edu.pnu.domain.LeadtimeSearchVO;
import edu.pnu.domain.LogVO;
import edu.pnu.domain.LeadtimeResultVO;
import edu.pnu.domain.PastLeadtimeVO;

@Repository
public class DataDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CategoryVO> getSelectList() {
		String sql = "SELECT * "
				+ "FROM leadtime_final";
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

	public void addLog(LogVO log) {
		String sql = "INSERT INTO search_log (machinery, items, part1) "
				+ "VALUES (?,?,?)";
		try {
			jdbcTemplate.update(sql, log.getMachinery(), log.getItems(), log.getPart1());
			System.out.println(log.getMachinery() + log.getItems() + log.getPart1());
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

	public void addBalju(BaljuVO[] balju) {
		for (BaljuVO b : balju) {
			//balju 배열의 전부를 하나씩 db로 인서트 할 수 있도록 반복문을 사용
			String sql = "INSERT INTO balju_data (machinery, items, part1, key2, baljucheo, leadtime_predicted, gyeonjeokhwapye, gyeonjeokdanga, baljusuryang, baljugeumaek) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			try {
				jdbcTemplate.update(sql, b.getMachinery(), b.getItems(), b.getPart1(), b.getKey2(),
						b.getBaljucheo(), b.getLeadtime_predicted(), b.getGyeonjeokhwapye(), b.getGyeonjeokdanga(), b.getBaljusuryang(), b.getBaljugeumaek());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}

	public List<BaljuVO> getBalju() {
		String sql = "SELECT * "
				+ "FROM balju_data";
		List<BaljuVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<BaljuVO>(BaljuVO.class));
		return list;
	}	
}
