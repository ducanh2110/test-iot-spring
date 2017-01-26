package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "liliaceae")
public class HoaLy {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "temperature")
	private float hoaly_temperature;
	private float humidity;
	private int brightness;
	private String nutrient;
	private Date createdTime;
	private Date updatedTime;

	public Integer getHoaly_id() {
		return id;
	}

	public void setHoaly_id(Integer id) {
		this.id = id;
	}

	public float getHoaly_temperature() {
		return hoaly_temperature;
	}

	public void setHoaly_temperature(float hoaly_temperature) {
		this.hoaly_temperature = hoaly_temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public String getNutrient() {
		return nutrient;
	}

	public void setNutrient(String nutrient) {
		this.nutrient = nutrient;
	}

	public Date getTime() {
		return createdTime;
	}

	public void setTime(Date time) {
		this.createdTime = time;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public HoaLy() {
	}

	@Override
	public String toString() {
		return "HoaLy [hoaly_id=" + id + ", hoaly_temperature=" + hoaly_temperature + ", humidity=" + humidity
				+ ", brightness=" + brightness + ", nutrient=" + nutrient
				+ ", time=" + createdTime + "]";
	}

	public HoaLy(Integer id, float hoaly_temperature, float humidity, int brightness, String nutrient,
			int nutrient_status, Date time) {
		this.id = id;
		this.hoaly_temperature = hoaly_temperature;
		this.humidity = humidity;
		this.brightness = brightness;
		this.nutrient = nutrient;
		this.createdTime = time;
	}

}
