package com.aem.myproject.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sys {
				
				private float type;
				private float id;
				private String country;
				private long sunrise;
				private long sunset;
				
				public float getType() {
								return type;
				}
				
				public void setType(float type) {
								this.type = type;
				}
				
				public float getId() {
								return id;
				}
				
				public void setId(float id) {
								this.id = id;
				}
				
				public String getCountry() {
								return country;
				}
				
				public void setCountry(String country) {
								this.country = country;
				}
				
				public long getSunrise() {
								return sunrise;
				}
				
				public void setSunrise(long sunrise) {
								this.sunrise = sunrise;
				}
				
				public long getSunset() {
								return sunset;
				}
				
				public void setSunset(long sunset) {
								this.sunset = sunset;
				}
}
