package edu.pnu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.BaljuVO;
import edu.pnu.domain.LeadtimeSearchVO;

@Repository
public class OrderDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<LeadtimeSearchVO> getSearch() {
		String sql = "SELECT * "
				+ "FROM leadtime_final";
		List<LeadtimeSearchVO> list = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<LeadtimeSearchVO>(LeadtimeSearchVO.class));
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
