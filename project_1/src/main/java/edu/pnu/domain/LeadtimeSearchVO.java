package edu.pnu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadtimeSearchVO {

	private String baljucheo;
	private String machinery;
	private String items;	//청구 품목
	private String part1;
	private String key2;
	private int leadtime_predicted;

}
