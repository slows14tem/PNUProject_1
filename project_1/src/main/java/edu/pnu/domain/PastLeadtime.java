package edu.pnu.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PastLeadtime {

	private String machinery;
	private String items;	//청구 품목
	private String part1; //Part No.1
	private int leadtime;
	
//	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate balju;
	
	public String getMachinery() {
		return machinery;
	}
	public void setMachinery(String machinery) {
		this.machinery = machinery;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getPart1() {
		return part1;
	}
	public void setPart1(String part1) {
		this.part1 = part1;
	}
	public int getLeadtime() {
		return leadtime;
	}
	public void setLeadtime(int leadtime) {
		this.leadtime = leadtime;
	}
	public LocalDate getBalju() {
		return balju;
	}
	public void setBalju(LocalDate balju) {
		this.balju = balju;
	}
	
	
	
	
	
}
