package AppInit;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import DAO.ConnectionManager;
import model.TipUcesca;

/**
 * Application Lifecycle Listener implementation class InitApp
 *
 */
public class InitApp implements ServletContextListener {

    
    public InitApp() { }

    //Pokrece se kada se aplikacija startuje, osluskuje kreiranje servlet konteksta
	public void contextInitialized(ServletContextEvent sce)  { 
        
		System.out.println("Start aplikacije");
		
		try {
    		System.out.println("Povezivanje sa bazom...");
    		ConnectionManager.open();
  
    		System.out.println("Uspeh!");
    	} catch (Exception ex) {
        	ex.printStackTrace();
    	}
		
		
		
		ServletContext ctx = sce.getServletContext();
    	
    	int brUc = 0; //kasnije bi trebalo citati broj ucesnika iz baze i postaviti brojUcesnika ? 
    	ctx.setAttribute("brUc", brUc);
    	
    	//kreiranje tipova ucesca
    	TipUcesca trkaZadovoljstva = new TipUcesca("trka zadovoljstva");
    	TipUcesca polumaraton = new TipUcesca("polumaraton");
    	TipUcesca maraton = new TipUcesca("maraton");
    	TipUcesca ultramaraton = new TipUcesca("ultramaraton");
    	//ArrayList<TipUcesca> tipoviUcesca = new ArrayList<TipUcesca>();
    	HashMap<String, TipUcesca> mapaTipoviUcesca = new HashMap<String, TipUcesca>();
    	
    	mapaTipoviUcesca.put("trkaZadovoljstva", trkaZadovoljstva);
    	mapaTipoviUcesca.put("polumaraton", polumaraton);
    	mapaTipoviUcesca.put("maraton", maraton);
    	mapaTipoviUcesca.put("ultramaraton", ultramaraton);
    	
    	//postavljanje tipova ucesca u Context na nivou aplikacije
    	ctx.setAttribute("tipoviucesca", mapaTipoviUcesca);
    	
/*    	//dodavalje u listu
    	tipoviUcesca.add(trkaZadovoljstva);
    	tipoviUcesca.add(polumaraton);
    	tipoviUcesca.add(maraton);
    	tipoviUcesca.add(ultramaraton);
    	//setovanje liste u Context
    	ctx.setAttribute("tipoviucesca", tipoviUcesca);
*/
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	try {
    		System.out.println("Zatvaranje veze sa bazom...");
    		ConnectionManager.close();
  
    		System.out.println("Uspeh!");
    	} catch (Exception ex) {
        	ex.printStackTrace();
    	}
    	
    }
	
}
