package edu.pnu.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogVO {
	
	private int id;
	private String machinery;
	private String items;	//청구 품목
	private String part1; //Part No.1
	private LocalDate logdate;

}
