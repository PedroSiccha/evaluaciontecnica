/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Pedro
 */
import java.util.List;
import model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Pedro
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
     @Query("SELECT i FROM Item i LEFT JOIN FETCH i.reviews r GROUP BY i HAVING COALESCE(AVG(r.rating), 0) < :rating")
    List<Item> findItemsWithAverageRatingLowerThan(Double rating);
}
