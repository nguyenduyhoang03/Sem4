package com.example.assignment.Repository;

import com.example.assignment.DTO.CategoryStatistic;
import com.example.assignment.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT new CategoryStatistic(c.id, c.name, SUM(p.price * p.quantitySold)) " +
            "FROM Product p JOIN p.category c GROUP BY c.id ORDER BY SUM(p.price * p.quantitySold) DESC")
    List<CategoryStatistic> findTopCategoriesByRevenue();
}

