package edu.pnu.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PastLeadtime {

	private String machinery;
	private String items;	//청구 품목
	private String part1; //Part No.1
	private int leadtime;
	private String key2;
	private LocalDate balju;	//발주일
	private String baljucheo;	//발주처
	private String gyeonjeokhwapye;	//견적화폐
	private int gyeonjeokdanga;	//견적 단가
	private int baljusuryang;	//발주 수량
	//private String baljugeumaek;	//발주 금액	int로도 String으로도 잘동 안됨
	
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
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public LocalDate getBalju() {
		return balju;
	}
	public void setBalju(LocalDate balju) {
		this.balju = balju;
	}
	public String getBaljucheo() {
		return baljucheo;
	}
	public void setBaljucheo(String baljucheo) {
		this.baljucheo = baljucheo;
	}
	public String getGyeonjeokhwapye() {
		return gyeonjeokhwapye;
	}
	public void setGyeonjeokhwapye(String gyeonjeokhwapye) {
		this.gyeonjeokhwapye = gyeonjeokhwapye;
	}
	public int getGyeonjeokdanga() {
		return gyeonjeokdanga;
	}
	public void setGyeonjeokdanga(int gyeonjeokdanga) {
		this.gyeonjeokdanga = gyeonjeokdanga;
	}
	public int getBaljusuryang() {
		return baljusuryang;
	}
	public void setBaljusuryang(int baljusuryang) {
		this.baljusuryang = baljusuryang;
	}
//	public int getBaljugeumaek() {
//		return baljugeumaek;
//	}
//	public void setBaljugeumaek(int baljugeumaek) {
//		this.baljugeumaek = baljugeumaek;
//	}

	
	
}
