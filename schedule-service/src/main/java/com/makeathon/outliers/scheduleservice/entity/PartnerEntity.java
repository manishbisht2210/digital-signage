package com.makeathon.outliers.scheduleservice.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "partners")
@AllArgsConstructor
@NoArgsConstructor
public class PartnerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer partnerId;
	
	private String password;
	
	private String name;

	@ToString.Exclude
	@OneToMany(fetch = FetchType.EAGER)
	private List<Screen> screens;
}
