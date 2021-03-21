package com.antulev.tracker;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackerController {
	
	@Autowired
	VehicalRepository vehicalRepository;
	
	@Autowired
	VestigeRepository vestigeRepository;
	
	@PostMapping(value = "/tracker")
	public Map<String, Object> tracker(@RequestBody Map<String, Object> body) {
		System.out.println(body);

		if(body.containsKey("deviceNo") && 
				body.containsKey("accelerate") && 
				body.containsKey("speed") && 
				body.containsKey("lat") && 
				body.containsKey("lng") && 
				body.containsKey("status")) {
			if(vehicalRepository.findById((String) body.get("deviceNo")).isPresent()) {
				Vestige vestige = new Vestige();
				vestige.setActive((boolean) body.get("status"));
				vestige.setVehicalId((String) body.get("deviceNo"));
				vestige.setLat((int) body.get("lat"));
				vestige.setLng((int) body.get("lng"));
				vestige.setCreatedDate(new Date());
				if(vestige.isActive()) {
					vestige.setAccelerate((int) body.get("accelerate"));
					vestige.setSpeed((int) body.get("speed"));
				}
				System.out.println("Save a vestige");
				vestige = vestigeRepository.save(vestige);
			}
		}
		return body;
	}
}
