package com.locadoraveiculosweb.util.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import lombok.Getter;

@Startup
@Singleton
public class Cache<T> {
	
	@Getter
	Map<String, Object> cache;
	
	@Schedule(minute = "1", hour = "*", persistent = false)
	@PostConstruct
	public void initializer() {
		cache = new HashMap<>();
	}
	
	public boolean containsKey(String key) {
		return cache.containsKey(key);
	}
	
	@Lock(LockType.READ)
	public Object getValue(String key){
	    return cache.get(key);
	}
	
	@Lock(LockType.WRITE)
	public void putValue(String key, Object values) {
		cache.put(key, values);
	}
	
}
