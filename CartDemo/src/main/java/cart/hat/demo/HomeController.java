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

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Blob;

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
		System.out.println("controller1");
		List<Product> productList = productDao.getProductList();
		ModelAndView model = new ModelAndView("productList");
		model.addObject("productList", productList);
		System.out.println("controller");
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
		ModelAndView model = new ModelAndView("productForm");
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
	public String upload(@RequestParam("name") String name, @RequestParam("age") Integer age,
			@RequestParam("photo") CommonsMultipartFile photo) throws IOException {
		productDao.insertRecords(name, age, photo);
		return "home";
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

	@RequestMapping(value = "/getStudentPhoto/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");
		System.out.println("get image");
		Blob ph = (Blob) productDao.getPhotoById(id);
		System.out.println("get image2");
		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

}
