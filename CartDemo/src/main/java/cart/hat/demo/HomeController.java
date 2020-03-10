package cart.hat.demo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cart.hat.demo.bean.Product;
import cart.hat.demo.dao.ProductDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	private ProductDao productDao = new ProductDao();	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		return "home";
	}
	
	 @RequestMapping({"/productList"})
	  public ModelAndView getProductList(@ModelAttribute Product fund)
	  {
	    List<Product> productList = productDao.getProductList();
	    ModelAndView model = new ModelAndView("productList");
	    model.addObject("productList", productList);
	    return model;
	  } 	
	 
	 @RequestMapping({"/viewProduct"})
	  public ModelAndView viewProduct(@RequestParam("producId") String productId) throws IOException 
	  
	  {			
			Product product= productDao.getProductById(productId);
			ModelAndView model = new ModelAndView("viewProduct");
		    model.addObject("product", product);
		    return model;	
	    
	  } 	
}	

