package com.nt.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;
import com.nt.repository.prod.IProductRepository;
import com.nt.repository.promotions.IOffersRepository;

@Component
public class MultiDBTestRunner implements CommandLineRunner {
	@Autowired
	private IProductRepository productRepo;
	@Autowired
	private IOffersRepository offersRepo;

	@Override
	public void run(String... args) throws Exception {
		//prepare the product object
		Product prod=new Product("Table",50000.0,10.0,"IKEA");
		//save the Product object
		int idVal=productRepo.save(prod).getPid();
		System.out.println("Product is saved with the id value :: "+idVal);
		System.out.println("===========================");
		
		//prepare the Offers object
		Offers offers=new Offers("Janmastami","JS-108",10.0f,LocalDateTime.now());
		//save the offer object
		int idVal1=offersRepo.save(offers).getOfferId();
		System.out.println("Offers is saved with id value :: "+idVal1);
	}

}
