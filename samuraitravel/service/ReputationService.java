package com.example.samuraitravel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraitravel.entity.Reputation;
import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.form.ReputationForm;
import com.example.samuraitravel.repository.ReputationRepository;
import com.example.samuraitravel.repository.UserRepository;

@Service
public class ReputationService {
	private final ReputationRepository reputationRepository;
	private final UserRepository userRepository; 
	
	public ReputationService(ReputationRepository reputationRepository,UserRepository userRepository) {
		this.reputationRepository = reputationRepository;
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void create(ReputationForm reputationForm) {
		Reputation reputation = new Reputation();
		User user = userRepository.getReferenceById(reputationForm.getUserId());
		int score = Integer.parseInt(reputationForm.getScore());
		
		reputation.setUser(user);
		reputation.setScore(score);
		reputation.setDescription(reputationForm.getDescription());
		
		reputationRepository.save(reputation);
	}
}
