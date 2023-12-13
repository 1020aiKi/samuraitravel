package com.example.samuraitravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Reputation;
import com.example.samuraitravel.form.ReputationForm;
import com.example.samuraitravel.repository.HouseRepository;
import com.example.samuraitravel.repository.ReputationRepository;
import com.example.samuraitravel.service.ReputationService;

@Controller
@RequestMapping("/houses/{id}")
public class ReputationController {
	private final HouseRepository houseRepository;     
	private final ReputationRepository reputationRepository;
	private final ReputationService reputationService;
	
    
    public ReputationController(HouseRepository houseRepository,ReputationRepository reputationRepository, ReputationService reputationService) {
        this.houseRepository = houseRepository;      
        this.reputationRepository = reputationRepository;
        this.reputationService = reputationService;

}
    @GetMapping("/reviews")
    public String index(@PathVariable(name = "id") Integer id, Model model) {
    	House house = houseRepository.getReferenceById(id);
    	
    	
    	model.addAttribute("reputationForm", new ReputationForm());   
    	model.addAttribute("house", house);   
    	 
    	
    	return "reviews/index";
}
    @GetMapping("/reviews/list")
    public String list(@PathVariable(name = "id") Integer id,Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
    	 Page<Reputation> reputationPage = reputationRepository.findAll(pageable);
    	 House house = houseRepository.getReferenceById(id);
    	 
    	 model.addAttribute("reputationPage", reputationPage);
    	 model.addAttribute("house", house);  
    	 
    	 return "reviews/show";   	
    }
    @PostMapping("/reviews/create")
    public String create(@ModelAttribute @Validated ReputationForm reputationForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
    	  if (bindingResult.hasErrors()) {
              return "reviews/index";
          }
    	 
      
          reputationService.create(reputationForm);      
          redirectAttributes.addFlashAttribute("successMessage", "民宿を登録しました。"); 
          
          
          return "redirect:/houses/show";
    }
}
