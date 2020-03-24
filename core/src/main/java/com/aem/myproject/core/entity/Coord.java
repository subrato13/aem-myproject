package com.aem.myproject.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coord {
				private float lon;
				private float lat;
				
				public float getLon() {
								return lon;
				}
				
				public void setLon(float lon) {
								this.lon = lon;
				}
				
				public float getLat() {
								return lat;
				}
				
				public void setLat(float lat) {
								this.lat = lat;
				}
}
