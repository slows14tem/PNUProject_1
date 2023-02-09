package edu.pnu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryVO {
	
	private String machinery;
	private String items;	//청구 품목
	private String part1; //Part No.1
	private String baljucheo;	//발주처

}
