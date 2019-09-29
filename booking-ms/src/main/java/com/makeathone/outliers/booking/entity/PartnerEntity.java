package com.makeathone.outliers.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "partners")
public class PartnerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer partnerId;
	
	private String password;
	
	private String name;
	
	@OneToMany
	private List<Screen> screens;
}
