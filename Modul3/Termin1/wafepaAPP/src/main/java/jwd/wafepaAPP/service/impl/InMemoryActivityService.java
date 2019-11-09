package jwd.wafepaAPP.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepaAPP.model.Activity;
import jwd.wafepaAPP.service.ActivityService;

public class InMemoryActivityService implements ActivityService {
	
	private Map<Long, Activity> activities
		= new HashMap<>(); // neke mape mogu da imaju null neke ne zavisi od implementacije
							// tj za kljuc null moze da bude pridruzen objekat 
	private long nextId = 1l;

	@Override
	public List<Activity> findAll() {
		
		return new ArrayList<> (activities.values());
		//return (List<Activity>) activities.values();
	}

	@Override
	public Activity findOne(Long id) {
		return activities.get(id);
	}

	@Override
	public Activity save(Activity activity) {
		if (activity.getId() == null ) {
				activity.setId(nextId);
				nextId +=1;
		}
		activities.put(activity.getId(), activity);
		return activity;
		
	}

	@Override
	public Activity delete(Long id) {
		if (!activities.containsKey(id)) {
			throw new IllegalArgumentException(
					"Tried to remove non-existing activity");
		}
		return activities.remove(id);
	}
	
	

}
