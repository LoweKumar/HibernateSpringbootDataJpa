package com.week3practive.jpaTutorial.jpaTuts;

import com.week3practive.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.week3practive.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = new ProductEntity().builder()
				.sku("nestle1234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
		List<ProductEntity> productEntities = productRepository.findByTitle("Pepsi");
		System.out.println(productEntities);
		List<ProductEntity> entities = productRepository
				.findByCreatedAtAfter(LocalDateTime
						.of(2024,1,1,0,0,0));

		System.out.println(entities);
		List<ProductEntity> likeEntities = productRepository.findByTitleLike("%Pepsi%");
		System.out.println(likeEntities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> productEntityOptional =
				productRepository.findByTitleAndPrice("Pepsi", BigDecimal.valueOf(12.4));
		productEntityOptional.ifPresent(System.out::println);
	}
}
