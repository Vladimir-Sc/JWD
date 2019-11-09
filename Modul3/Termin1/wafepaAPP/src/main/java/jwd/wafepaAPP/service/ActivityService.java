package jwd.wafepaAPP.service;

import java.util.List;

import jwd.wafepaAPP.model.Activity;

public interface ActivityService {
	
	List<Activity> findAll();
	Activity findOne(Long id);
	Activity save(Activity activity); // vracamo novo stanje Activity objekta (mozda je dodat id)
	// void save(Activity activity);
	Activity delete(Long id);

}
