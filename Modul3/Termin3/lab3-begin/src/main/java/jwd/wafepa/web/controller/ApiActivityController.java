package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.support.ActivityDTOToActivity;
import jwd.wafepa.support.ActivityToActvityDTO;
import jwd.wafepa.web.dto.ActivityDTO;

@RestController
@RequestMapping(value="/api/activities")
public class ApiActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private ActivityToActvityDTO toDTO;
	
	@Autowired
	private ActivityDTOToActivity toAct;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<ActivityDTO>> getActivities(@RequestParam String name){
		
		//List<Activity> activities = activityService.findAll();
		List<Activity> activities;
		
		if (name==null) {
			activities = activityService.findAll();
		}else {
			
			activities = activityService.findByName(name);
		}
		
		
		
		List<ActivityDTO> activitiesDTO = new ArrayList<>();
		
		activitiesDTO = toDTO.convert(activities);
		
		return new ResponseEntity<>(activitiesDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id){
		Activity activity = activityService.findOne(id);
		if(activity==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		//activity.setAdminComment(null);
		
//		ActivityDTO dto = new ActivityDTO();
//		dto.setId(activity.getId());
//		dto.setName(activity.getName());
		
		return new ResponseEntity<>(toDTO.convert(activity),HttpStatus.OK); 
		// return new ResponseEntity<>(activity,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<ActivityDTO> delete(@PathVariable Long id){
		
		
		Activity forDel = activityService.findOne(id);
		
		ActivityDTO forDelDTO = toDTO.convert(forDel);
		
		//Activity deleted = activityService.delete(id);
		
		if(forDelDTO == null) {
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(forDelDTO,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<Activity> add(@RequestBody Activity newActivity){
		
		
		ActivityDTO toaddActivityDTO = new ActivityDTO();
		
		
		
		Activity savedActivity = activityService.save(newActivity);
		
		return new ResponseEntity<>(savedActivity, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<Activity> edit(
			@RequestBody Activity activity,
			@PathVariable Long id){
		
		if(!id.equals((activity.getId()))) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Activity persisted = activityService.save(activity);
		
		return new ResponseEntity<>(persisted,HttpStatus.OK);
	}
	
	
}
