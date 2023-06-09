package com.vanmetie.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vanmetie.demo.dto.SpecimenDTO;
import com.vanmetie.demo.service.ISpecimenService;

@Controller
public class DemoController {
	
	@Autowired
	private ISpecimenService specimenServiceStub;
	
	@RequestMapping("/start")
	public String start() {
		return "start";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) {
		SpecimenDTO specimenDTO = specimenServiceStub.fetchById(43);
		model.addAttribute("specimenDTO", specimenDTO);
		return "start";
	}
}
