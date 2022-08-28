package com.rest.services.restservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(value="person/params",params="version=1")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="person/params",params="version=2")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(value="person/header",headers="X-API-VERSION=1")
	public PersonV1 getPersonV1ByHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="person/header",headers="X-API-VERSION=2")
	public PersonV2 getPersonV2ByHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	
	
	
}
