package cart.hat.demo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cart.hat.demo.bean.Product;
import cart.hat.demo.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	ProductService productService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping({ "/productList" })
	public ModelAndView getProductList(Product product) {
		List<Product> productList = productService.getProductList(product);
		ModelAndView model = new ModelAndView("productList");
		model.addObject("productList", productList);
		return model;
	}

	@RequestMapping({ "/insert" })
	public ModelAndView addProduct(@ModelAttribute Product product) {
		if (product.getProductName() != null) {			
			productService.insertProduct(product);
		}
		ModelAndView model = new ModelAndView("home");
		return model;
	}

	@RequestMapping({ "/productForm" })
	public ModelAndView getProductForm(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("productForm");
		return model;
	}
	
	@RequestMapping({ "/viewProduct" })
	public ModelAndView getProduct(Product product) {
		List<Product> productList = productService.getProductList(product);
		ModelAndView model = new ModelAndView("viewProduct");
		model.addObject("productList", productList);
		return model;
	}
	
	
		
}


