package edu.pnu.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PastLeadtimeVO {

	private String machinery;
	private String items;	//청구 품목
	private String part1; //Part No.1
	private int leadtime;
	private LocalDate balju;	//발주일
	private String baljucheo;	//발주처
	private String gyeonjeokhwapye;	//견적화폐
	private int gyeonjeokdanga;	//견적 단가
	private int baljusuryang;	//발주 수량
	private String baljugeumaek;	//발주 금액	int로도 String으로도 잘동 안됨

}
