package com.nts.pjt3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ReservationController {


	@GetMapping(path = "/mainpage")
	public String mainPage(ModelMap modelMap) {
		
		return "mainpage";
	}

	/*
	 * @GetMapping(path = "/myreservation") public String myReservation(ModelMap
	 * modelMap) { return "myreservation"; }
	 * 
	 * @GetMapping(path = "/detail") public String detail(@RequestParam(name = "id")
	 * int id, ModelMap modelMap) { Product product =
	 * productService.getOneProduct(id); ProductImage productImage =
	 * productImageService.getProductImages(product.getId(), "ma").get(0);
	 * DisplayInfoImage displayInfoImage =
	 * displayInfoImageService.getDisPlayInfoImageByID(product.getDisplayInfoId());
	 * modelMap.addAttribute("product", product);
	 * modelMap.addAttribute("displayInfoImage", displayInfoImage);
	 * modelMap.addAttribute("productImage", productImage); return "detail"; }
	 * 
	 * @GetMapping(path = "/bookinglogin") public String bookinglogin(ModelMap
	 * modelMap) { return "bookinglogin"; }
	 * 
	 * @GetMapping(path = "/review") public String review(ModelMap modelMap) {
	 * return "review"; }
	 * 
	 * @GetMapping(path = "/reviewWrite") public String reviewWrite(ModelMap
	 * modelMap) { return "reviewWrite"; }
	 */
}
