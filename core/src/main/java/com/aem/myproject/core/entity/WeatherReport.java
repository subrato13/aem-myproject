package com.aem.myproject.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherReport {
				Coord coord;
				List<Object> weather = new ArrayList<>();
				private String base;
				Main main;
				private float visibility;
				Wind wind;
				Clouds clouds;
				private float dt;
				Sys sys;
				private float timezone;
				private float id;
				private String name;
				private float cod;
				
				public Coord getCoord() {
								return coord;
				}
				
				public void setCoord(Coord coord) {
								this.coord = coord;
				}
				
				public List<Object> getWeather() {
								return weather;
				}
				
				public void setWeather(List<Object> weather) {
								this.weather = weather;
				}
				
				public String getBase() {
								return base;
				}
				
				public void setBase(String base) {
								this.base = base;
				}
				
				public Main getMain() {
								return main;
				}
				
				public void setMain(Main main) {
								this.main = main;
				}
				
				public float getVisibility() {
								return visibility;
				}
				
				public void setVisibility(float visibility) {
								this.visibility = visibility;
				}
				
				public Wind getWind() {
								return wind;
				}
				
				public void setWind(Wind wind) {
								this.wind = wind;
				}
				
				public Clouds getClouds() {
								return clouds;
				}
				
				public void setClouds(Clouds clouds) {
								this.clouds = clouds;
				}
				
				public float getDt() {
								return dt;
				}
				
				public void setDt(float dt) {
								this.dt = dt;
				}
				
				public Sys getSys() {
								return sys;
				}
				
				public void setSys(Sys sys) {
								this.sys = sys;
				}
				
				public float getTimezone() {
								return timezone;
				}
				
				public void setTimezone(float timezone) {
								this.timezone = timezone;
				}
				
				public float getId() {
								return id;
				}
				
				public void setId(float id) {
								this.id = id;
				}
				
				public String getName() {
								return name;
				}
				
				public void setName(String name) {
								this.name = name;
				}
				
				public float getCod() {
								return cod;
				}
				
				public void setCod(float cod) {
								this.cod = cod;
				}
}
