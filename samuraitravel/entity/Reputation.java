package com.example.samuraitravel.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="reputations")
@Data
public class Reputation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	@Column(name ="name")
	private String name;
	@Column(name="score")
	private Integer score;
	@Column(name ="month")
	private String month;
	@Column(name ="description")
	private String description;
	@Column(name ="created_at",insertable = false, updatable = false)
	private Timestamp createdAt;
	@Column(name ="updated_at",insertable = false, updatable = false)
	private Timestamp updataedAt;
}
