package cate_pro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cate_pro.dao.CategoryDAO;
import cate_pro.dao.ProductDAO;
import cate_pro.entities.Category;
import cate_pro.entities.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf,true));
	}
	
	@RequestMapping(value = {"/","/home"})
	public String home(Model model) {
		List<Product> listProducts = productDAO.getListProducts();
		model.addAttribute("list", listProducts);
		return "home";
	}
	
	@RequestMapping("/initInsertProduct")
	public String initInsertProduct(Model model) {
		Product p = new Product();
		model.addAttribute("p", p);
		
		List<Category> categories = categoryDAO.getCategories();
		model.addAttribute("listCate", categories);
		
		return "insertProduct";
	}
	
	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute("p")Product p, Model model) {
		boolean bl = productDAO.insertProduct(p);
		if(bl) {
			return "redirect:/home"; // return url cua controller
		}else {
			model.addAttribute("error", "Insert failed!");
			model.addAttribute("p", p);
			
			List<Category> categories = categoryDAO.getCategories();
			model.addAttribute("listCate", categories);
			
			return "insertProduct";
		}
	}
}
