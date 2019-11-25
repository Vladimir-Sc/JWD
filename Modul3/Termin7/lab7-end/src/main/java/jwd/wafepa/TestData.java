package jwd.wafepa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.joran.action.ReceiverAction;
import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Address;
import jwd.wafepa.model.Record;
import jwd.wafepa.model.User;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.AddressService;
import jwd.wafepa.service.RecordService;
import jwd.wafepa.service.UserService;

@Component
public class TestData {

	@Autowired
	private ActivityService activityService;

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private RecordService recordService;

	@PostConstruct
	public void init() {
		
		activityService.save(new Activity("Swimming"));
		activityService.save(new Activity("Running"));
		activityService.save(new Activity("Climbing"));
		
		//test start za activity/user/record ---------------------------------
		
//		Activity act1 = new Activity("Swimming");
//		Activity act2 = new Activity("Runing");
//		
//		activityService.save(act1);
//		activityService.save(act2);
//
//		User user1 = new User("pera2@gmail.com", "pass", "pera2", "peric2");
//		User user2 = new User("pera@gmail.com", "pass", "pera", "peric");
//		
//		userService.save(user1);
//		userService.save(user2);
//		
////		Record record1= new Record("10", 5, "low",  user1, act1);
////		Record record2= new Record("20", 11, "medium",  user1, act1);
////		Record record3= new Record("65", 6, "hard",  user1, act2);
//		
//		
//		Record record1= new Record("10", 5, "low", user1, act1);
//		Record record2= new Record("20", 11, "medium", user1, act1);
//		Record record3= new Record("65", 6, "hard", user1, act2);
//
//		
//		//user1.addRecords(record1);
//		//user1.addRecords(record2);
//		//user1.addRecords(record3);
//		
//		//userService.save(user1);
//		//userService.save(user2);
//		
//		recordService.save(record1);
//		recordService.save(record2);
//		recordService.save(record3);
		
		//test end za activity/user/record ---------------------------------
		
		
/*		
		drugi nacin ? 
		
		Activity act1 = new Activity("Swimming");
		Activity act2 = new Activity("Runing");


		User user1 = new User("pera2@gmail.com", "pass", "pera2", "peric2");
		User user2 = new User("pera@gmail.com", "pass", "pera", "peric");

		
		
		Record record1= new Record("10", 5, "low", user1, act1);
		Record record2= new Record("20", 11, "medium", user1, act1);
		Record record3= new Record("65", 6, "hard", user1, act2);

		user1.addRecords(record1);
		user1.addRecords(record2);
		user1.addRecords(record3);
		
		userService.save(user1);
		userService.save(user2);

		
*/		
		
		
		//ispis na konzoli-test
//		Record record11 = recordService.findOne(1l);
//		Record record12 = recordService.findOne(2l);
//		Record record13 = recordService.findOne(3l);
//		
//		System.out.println(user1);
//		
//		user1.addRecords(record11);
//		user1.addRecords(record12);
//		user1.addRecords(record13);
//		
//		System.out.println(user1);


		
		//test za user/address ---------------------------------------------
		
		//pravimo 5 korisnika
		for (int i = 1; i <= 5; i++) {
			User user = new User();
			user.setFirstName("First name " + i);
			user.setLastName("Last name " + i);
			user.setEmail("email" + i + "@example.com");
			user.setPassword("123");
			userService.save(user);

			//za svakog korisnika pravimo po 3 adrese
			for (int j = 1; j <= 3; j++) {
				Address address = new Address();
				address.setNumber(Integer.toString(j));
				address.setStreat("Laze nancica");
				
				addressService.save(address);
				
				user.addAddress(address);
				addressService.save(address);
				userService.save(user);
			}
		}

		
		//drugi nacin?
		// pravimo 5 korisnika
//		for (int i = 1; i <= 5; i++) {
//			User user = new User();
//			user.setFirstName("First name " + i);
//			user.setLastName("Last name " + i);
//			user.setEmail("email" + i + "@example.com");
//			user.setPassword("123");
//
//			// za svakog korisnika pravimo po 3 adrese
//			for (int j = 1; j <= 3; j++) {
//				Address address = new Address("laze teleckog", Integer.toString(j), user);
//				user.addAddress(address);
//			}
//
//			userService.save(user);
//		}

	}
}
