package com.example.samuraitravel.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

 @Data
public class ReputationForm {
	 private Integer id;
	 
	 private String name;
	 
	private Integer score;
	
	private String month;
	
	@NotBlank(message="文字を入力して下さい")
	private String description;
}
