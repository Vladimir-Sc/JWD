package jwd.wafepaAPP.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jwd.wafepaAPP.model.Activity;
import jwd.wafepaAPP.service.impl.InMemoryActivityService;

public class InMemoryActivityServiceTest {
	
	private ActivityService activityService;
	
	@Before
	public void setUp() {
		activityService = new InMemoryActivityService();
		
		Activity swimming = new Activity("Swimming");
		Activity running = new Activity("Running");
		
		activityService.save(swimming);
		activityService.save(running);
		
	}
	
	@Test
	public void testFindOne() {
		
		Activity res = activityService.findOne(2l);
		
		Assert.assertEquals("Running", res.getNaziv());
	}
	
	@Test
	public void testFindAll() {
		
		List<Activity> res = activityService.findAll();
		
		Assert.assertEquals(2, res.size());
	}
	
	
}
