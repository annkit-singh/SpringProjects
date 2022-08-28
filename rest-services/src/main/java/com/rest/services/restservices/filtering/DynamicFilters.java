package com.rest.services.restservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Component
public class DynamicFilters {
	
public MappingJacksonValue customFilter(Object obj,String filterName,String... propertyArray) {
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray);

		FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
		MappingJacksonValue mapping = new MappingJacksonValue(obj);
		mapping.setFilters(filters);
		return mapping;
		
	}

}
