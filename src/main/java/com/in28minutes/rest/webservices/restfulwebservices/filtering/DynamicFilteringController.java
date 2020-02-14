package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilteringController {
    @GetMapping("/dynamic/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        FilterBean filterBean = new FilterBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("FilterBeanId",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filterBean);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
    /*@GetMapping("/dynamic/filtering-list")
    public SomeBean retrieveSomeBeanList() {
        FilterBean filterBean = new FilterBean("value1", "value2", "value3");

        return new SomeBean("value1","value2","value3");
    }*/
}
