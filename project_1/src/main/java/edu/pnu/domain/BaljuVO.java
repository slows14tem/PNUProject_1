package edu.pnu.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaljuVO {
	
	private int id;
	private String machinery;
	private String items;
	private String part1;
	private String key2;
	private String baljucheo;
	private String leadtime_predicted;
	private String gyeonjeokhwapye;
	private String gyeonjeokdanga;
	private int baljusuryang;
	private int baljugeumaek;
	private LocalDate date;
	
	
	
}
