package com.andy.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "product", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id")})
public class Product implements java.io.Serializable{
	private String id;
	private String name;
	private String barCode;
//	private String description;
//	private Date priduceDate;
//	private Date bestBeforeDate;
//	private int bestBeforeDays;
//	private int bestBeforeDaysRemain;
//	private String barCode;
//	private int storedDays;
//	private boolean isExpired;
//	private boolean isInstant;
//	private String catagory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "name", unique = false, nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "barcode", unique = true, nullable = false)
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	/*
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPriduceDate() {
		return priduceDate;
	}
	public void setPriduceDate(Date priduceDate) {
		this.priduceDate = priduceDate;
	}
	public Date getBestBeforeDate() {
		return bestBeforeDate;
	}
	public void setBestBeforeDate(Date bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}
	public int getBestBeforeDays() {
		return bestBeforeDays;
	}
	public void setBestBeforeDays(int bestBeforeDays) {
		this.bestBeforeDays = bestBeforeDays;
	}
	public int getBestBeforeDaysRemain() {
		return bestBeforeDaysRemain;
	}
	public void setBestBeforeDaysRemain(int bestBeforeDaysRemain) {
		this.bestBeforeDaysRemain = bestBeforeDaysRemain;
	}
	
	
	public int getStoredDays() {
		return storedDays;
	}
	public void setStoredDays(int storedDays) {
		this.storedDays = storedDays;
	}
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	public boolean isInstant() {
		return isInstant;
	}
	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	*/
	public String toString(){
		return "The product is: "+name+", the id is: "+id+", the barcode is: "+barCode;
	}

}
