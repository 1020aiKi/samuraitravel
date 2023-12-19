package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.Reputation;
import com.example.samuraitravel.entity.User;
public interface ReputationRepository extends JpaRepository<Reputation,Integer>{
	 public Page<Reputation> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
	 public List<Reputation> findTopByOrderByIdDesc();
	 
}
