package com.ftninformatika.vezbe09.webshop;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ftninformatika.vezbe09.webshop.dao.ConnectionManager;

public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event)  { 
    	try {
    		System.out.println("Zatvaranje veze sa bazom...");
    		ConnectionManager.close();
  
    		System.out.println("Uspeh!");
    	} catch (Exception ex) {
        	ex.printStackTrace();
    	}
    }

    public void contextInitialized(ServletContextEvent event)  {
    	try {
    		System.out.println("Povezivanje sa bazom...");
    		ConnectionManager.open();
  
    		System.out.println("Uspeh!");
    	} catch (Exception ex) {
        	ex.printStackTrace();
    	}
    }

}
