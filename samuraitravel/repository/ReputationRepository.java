package com.example.samuraitravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.Reputation;
public interface ReputationRepository extends JpaRepository<Reputation,Integer>{
	public Page<Reputation> findByNameLike(String keywords,Pageable pageable);
}
