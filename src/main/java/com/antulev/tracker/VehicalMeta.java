package com.antulev.tracker;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "vehicalMeta", types= { Vehical.class})
public interface VehicalMeta {
	String getId();
	String getOwnerName();
	String getCarNumber();
	Group getGroup();
}
