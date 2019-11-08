package zadatak2;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.TipUcesca;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
public class AppListener implements ServletContextListener {

    
    public AppListener() { }

    //Pokrece se kada se aplikacija startuje, osluskuje kreiranje servlet konteksta
    public void contextInitialized(ServletContextEvent sce)  {
        
        ServletContext ctx = sce.getServletContext();
        
        System.out.println("Start aplikacije");
        
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
        
/*        //dodavalje u listu
        tipoviUcesca.add(trkaZadovoljstva);
        tipoviUcesca.add(polumaraton);
        tipoviUcesca.add(maraton);
        tipoviUcesca.add(ultramaraton);
        //setovanje liste u Context
        ctx.setAttribute("tipoviucesca", tipoviUcesca);
*/
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 


        //prikaz broja ucesnika
		int brojU = (int) getServletContext().getAttribute("brUc");
		brojU++;
		getServletContext().setAttribute("brUc", brojU);

        System.out.println("Broj ucesnika je:" + getServletContext().getAttribute("brUc"));


    }
    
}