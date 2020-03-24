package com.aem.myproject.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Clouds {
				private float all;
				
				public float getAll() {
								return all;
				}
				
				public void setAll(float all) {
								this.all = all;
				}
}
