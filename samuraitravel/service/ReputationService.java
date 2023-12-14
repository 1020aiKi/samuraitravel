package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraitravel.entity.Reputation;
import com.example.samuraitravel.form.ReputationForm;
import com.example.samuraitravel.repository.ReputationRepository;


@Service
public class ReputationService {
	private final ReputationRepository reputationRepository;
	
	
	
	public ReputationService(ReputationRepository reputationRepository) {
		this.reputationRepository = reputationRepository;
		  
		
	}
	
	@Transactional
	public void create(ReputationForm reputationForm) {
		Reputation reputation = new Reputation();
		  
				
		reputation.setScore(reputationForm.getUserId());
		reputation.setScore(reputationForm.getScore());
		reputation.setDescription(reputationForm.getDescription());
		
		reputationRepository.save(reputation);
	}
}
