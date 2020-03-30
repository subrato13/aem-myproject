package com.aem.myproject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import java.util.Date;

@Model(adaptables = Resource.class,
				defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class WaterHeightList {
				private Date datefield;
				private String height;
}
