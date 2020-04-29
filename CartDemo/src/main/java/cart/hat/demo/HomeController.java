package cart.hat.demo;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Blob;
import java.sql.SQLException;

import cart.hat.demo.bean.Product;
import cart.hat.demo.dao.ProductDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	ProductDao productDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping({ "/productList" })
	public ModelAndView getProductList(Product product) {

		List<Product> productList = productDao.getProductList();
		ModelAndView model = new ModelAndView("file");
		model.addObject("productList", productList);

		return model;
	}

	@RequestMapping({ "/adminList" })
	public ModelAndView getAdminList(Product product) {

		List<Product> productList = productDao.getProductList();
		ModelAndView model = new ModelAndView("admin");
		model.addObject("productList", productList);
		return model;
	}

	@RequestMapping({ "/insert" })
	public ModelAndView addProduct(@ModelAttribute int product) {
		productDao.getProduct(product);

		ModelAndView model = new ModelAndView("home");
		return model;
	}

	@RequestMapping({ "/productForm" })
	public ModelAndView getProductForm(@ModelAttribute Product product) {
		System.out.println(product.getProductName());
		ModelAndView model = new ModelAndView("productForm");
		model.addObject("productForm", new Product());
		return model;
	}

	@RequestMapping({ "/cart" })
	public ModelAndView getCart(@RequestParam("productId") int productId) {
		List<Product> productList = productDao.getProduct(productId);
		ModelAndView model = new ModelAndView("cart");
		model.addObject("productList", productList);
		return model;
	}

	@RequestMapping({ "/viewProduct" })
	public ModelAndView listNotes(@RequestParam("productId") int productId) {
		List<Product> productList = productDao.getProduct(productId);
		ModelAndView model = new ModelAndView("viewProduct");
		model.addObject("productList", productList);
		return model;
	}

	@RequestMapping({ "/save" })
	public String upload(@ModelAttribute("productForm") @Valid Product product, BindingResult result) throws IOException {

		if (result.hasErrors()) {

			return "productForm";
		}

		// productDao.insertRecords(name, photo, age);
		return "redirect:/adminList";
	}

	@RequestMapping(value = "/getStudentPhoto/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");
		Blob ph = (Blob) productDao.getPhotoById(id);
		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

	@RequestMapping({ "/editProduct" })
	public String editTransfer(@RequestParam("name") String name, @RequestParam("photo") CommonsMultipartFile photo,
			@RequestParam("age") Integer age, @RequestParam("id") int id) throws IOException, SQLException {
		productDao.updateRecords(name, photo, age, id);
		return "redirect:/adminList";
	}

	@RequestMapping({ "/delete" })
	public String delete(@RequestParam("productId") int productId) {
		productDao.delete(productId);
		return "redirect:/adminList";
	}

	@RequestMapping({ "/editForm" })
	public ModelAndView editForm(@RequestParam("productId") int productId) {
		List<Product> productList = productDao.getProduct(productId);
		ModelAndView model = new ModelAndView("editProduct");
		model.addObject("productList", productList);
		return model;
	}
}
