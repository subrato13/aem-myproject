package com.aem.myproject.core.entity;

public class WeatherReport {
				private String countryCode;
				private String cityName;
				private String currentDateTime;
				private float windSpeed;
				private String temperature;
				private String pressure;
				private String humidity;
				private String weatherType;
				private String weatherDescription;
				private String sunrise;
				private String sunset;
				private float latitude;
				private float longitude;
				
				public String getCountryCode() {
								return countryCode;
				}
				
				public void setCountryCode(String countryCode) {
								this.countryCode = countryCode;
				}
				
				public String getCityName() {
								return cityName;
				}
				
				public void setCityName(String cityName) {
								this.cityName = cityName;
				}
				
				public String getTemperature() {
								return temperature;
				}
				
				public void setTemperature(String temperature) {
								this.temperature = temperature;
				}
				
				public String getPressure() {
								return pressure;
				}
				
				public void setPressure(String pressure) {
								this.pressure = pressure;
				}
				
				public String getHumidity() {
								return humidity;
				}
				
				public void setHumidity(String humidity) {
								this.humidity = humidity;
				}
				
				public String getWeatherType() {
								return weatherType;
				}
				
				public void setWeatherType(String weatherType) {
								this.weatherType = weatherType;
				}
				
				public String getWeatherDescription() {
								return weatherDescription;
				}
				
				public void setWeatherDescription(String weatherDescription) {
								this.weatherDescription = weatherDescription;
				}
				
				public String getSunrise() {
								return sunrise;
				}
				
				public void setSunrise(String sunrise) {
								this.sunrise = sunrise;
				}
				
				public String getSunset() {
								return sunset;
				}
				
				public void setSunset(String sunset) {
								this.sunset = sunset;
				}
				
				public float getLatitude() {
								return latitude;
				}
				
				public void setLatitude(float latitude) {
								this.latitude = latitude;
				}
				
				public float getLongitude() {
								return longitude;
				}
				
				public void setLongitude(float longitude) {
								this.longitude = longitude;
				}
				
				public String getCurrentDateTime() {
								return currentDateTime;
				}
				
				public void setCurrentDateTime(String currentDateTime) {
								this.currentDateTime = currentDateTime;
				}
				
				public float getWindSpeed() {
								return windSpeed;
				}
				
				public void setWindSpeed(float windSpeed) {
								this.windSpeed = windSpeed;
				}
}
