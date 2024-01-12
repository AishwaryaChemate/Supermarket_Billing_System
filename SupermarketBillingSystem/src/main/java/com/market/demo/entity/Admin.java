package com.market.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
public class Admin {
	
	@Id
	private int aId;
	
	@Column (length=15, nullable = false)
	@NotBlank(message= "Admin's username cannot be blank")
	private String username;
	
	@Column (length=10, nullable = false)
	@NotBlank(message= "Admin's password cannot be blank")
	private String password;
}
