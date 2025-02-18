package com.week3practive.jpaTutorial.jpaTuts.repositories;

import com.week3practive.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);
    List<ProductEntity> findByOrderByPrice();
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);
    List<ProductEntity> findByTitleLike(String title);
    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
//    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
    @Query("Select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
