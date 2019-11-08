package com.ftninformatika.vezbe06.webshop;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import com.ftninformatika.vezbe06.webshop.dao.ConnectionManager;

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
    	
    	ServletContext ctx = event.getServletContext();
    	int[] intArray = new int[3];
    	
    	int brojUcesnika = 0;
    	
    	intArray[0] = 3;
    	intArray[1] = 2;
    	intArray[2] = 5;
    	
    	ctx.setAttribute("lista", intArray);
    	ctx.setAttribute("brojUcesnika", brojUcesnika);
    	
    	int[] intArray2 = (int[]) (ctx.getAttribute("lista")); 
    	
    	
    	for (int i=0; i<intArray2.length; i++) {
    		
    		System.out.println(intArray2[i]);
    		
    	}
    	
    	
    
    	
    	
    	try {
    		System.out.println("Povezivanje sa bazom...");
    		ConnectionManager.open();
  
    		System.out.println("Uspeh!");
    	} catch (Exception ex) {
        	ex.printStackTrace();
    	}
    }

}
