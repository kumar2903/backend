package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
	@Id
	private int Price;
	private String Brand;
	@Column(name="Operating_System")
	private String  opsys;
	@Column(name="Installed_Memory")
	private String insmem;
	@Column(name="Battery_life")
	private String batlife;
	private  String  weight;
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getOpsys() {
		return opsys;
	}
	public void setOpsys(String opsys) {
		this.opsys = opsys;
	}
	public String getInsmem() {
		return insmem;
	}
	public void setInsmem(String insmem) {
		this.insmem = insmem;
	}
	public String getBatlife() {
		return batlife;
	}
	public void setBatlife(String batlife) {
		this.batlife = batlife;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	

}
