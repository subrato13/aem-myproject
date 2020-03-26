package com.aem.myproject.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Properties {
				private float id;
				private String main;
				private String description;
				private String icon;
		
				public float getId() {
								return id;
				}
				
				public String getMain() {
								return main;
				}
				
				public String getDescription() {
								return description;
				}
				
				public String getIcon() {
								return icon;
				}
				
				public void setId(float id) {
								this.id = id;
				}
				
				public void setMain(String main) {
								this.main = main;
				}
				
				public void setDescription(String description) {
								this.description = description;
				}
				
				public void setIcon(String icon) {
								this.icon = icon;
				}
}
