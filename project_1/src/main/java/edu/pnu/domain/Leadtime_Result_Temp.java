package edu.pnu.domain;

public class Leadtime_Result_Temp {

	private String machinery;
	private String items;
	private String part1;
	private int avg_leadtime;
	private int stdev_leadtime;
	
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
	public int getAvg_leadtime() {
		return avg_leadtime;
	}
	public void setAvg_leadtime(int avg_leadtime) {
		this.avg_leadtime = avg_leadtime;
	}
	public int getStdev_leadtime() {
		return stdev_leadtime;
	}
	public void setStdev_leadtime(int stdev_leadtime) {
		this.stdev_leadtime = stdev_leadtime;
	}

	
}
