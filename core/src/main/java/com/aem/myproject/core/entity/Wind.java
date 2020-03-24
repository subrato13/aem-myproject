package com.aem.myproject.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wind {
				private float speed;
				private float deg;
				
				public float getSpeed() {
								return speed;
				}
				
				public void setSpeed(float speed) {
								this.speed = speed;
				}
				
				public float getDeg() {
								return deg;
				}
				
				public void setDeg(float deg) {
								this.deg = deg;
				}
}
