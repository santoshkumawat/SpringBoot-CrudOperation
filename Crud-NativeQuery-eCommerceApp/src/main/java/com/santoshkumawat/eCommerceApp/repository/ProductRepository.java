package com.santoshkumawat.eCommerceApp.repository;

import com.santoshkumawat.eCommerceApp.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Product where name = :name", nativeQuery = true)
    List<Product> findByName(@Param("name") String name);

    @Modifying
    @Query(value = "INSERT INTO PRODUCT (name, price) VALUES (:name, :price)", nativeQuery = true)
    void addProduct(@Param("name") String name, @Param("price") Double price);

    @Modifying
    @Query(value = "UPDATE Product SET name = :name, price = :price WHERE id = :id", nativeQuery = true)
    void updateProduct(@Param("id") Long id, @Param("name") String name, @Param("price") Double price);

    @Modifying
    @Query(value = "DELETE FROM Product WHERE id = :id", nativeQuery = true)
    void deleteProductById(@Param("id") Long id);

}