package cart.hat.demo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
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
		List<Product> productList = productService.getProductList();
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
	public ModelAndView listNotes(@RequestParam("productId") int productId) {
		System.out.println(productId);
		List<Product> productList = productService.getProduct(productId);
		ModelAndView model = new ModelAndView("viewProduct");
		model.addObject("productList", productList);
		return model;
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();

		System.out.println(path + " " + filename);
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("upload-success", "filename", path + "/" + filename);
	}

}
