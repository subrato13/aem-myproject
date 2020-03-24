package com.aem.myproject.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Main {
				private float temp;
				
				@JsonProperty("feels_like")
				private float feelsLike;
				@JsonProperty("temp_min")
				private float tempMin;
				@JsonProperty("temp_max")
				private float tempMax;
				private float pressure;
				private float humidity;
				
				public float getTemp() {
								return temp;
				}
				
				public void setTemp(float temp) {
								this.temp = temp;
				}
				
				public float getFeelsLike() {
								return feelsLike;
				}
				
				public void setFeelsLike(float feelsLike) {
								this.feelsLike = feelsLike;
				}
				
				public float getTempMin() {
								return tempMin;
				}
				
				public void setTempMin(float tempMin) {
								this.tempMin = tempMin;
				}
				
				public float getTempMax() {
								return tempMax;
				}
				
				public void setTempMax(float tempMax) {
								this.tempMax = tempMax;
				}
				
				public float getPressure() {
								return pressure;
				}
				
				public void setPressure(float pressure) {
								this.pressure = pressure;
				}
				
				public float getHumidity() {
								return humidity;
				}
				
				public void setHumidity(float humidity) {
								this.humidity = humidity;
				}
}
