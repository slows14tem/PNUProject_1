package edu.pnu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadtimeResultVO {

	private String machinery;
	private String items;
	private String part1;
	private int leadtime_predicted;
	
}
