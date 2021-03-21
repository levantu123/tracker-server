package com.antulev.tracker;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicalRepository extends MongoRepository<Vehical, String> {
	
}
