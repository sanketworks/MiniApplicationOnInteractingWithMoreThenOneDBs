package com.nt.model.prod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name ="MULTI_DB_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(length = 25)
	@NonNull
	private String pname;
	
	@NonNull
	private Double price;
	
	@NonNull
	private Double qty;
	
	@NonNull
	@Column(length = 25)
	private String vendor;

}
