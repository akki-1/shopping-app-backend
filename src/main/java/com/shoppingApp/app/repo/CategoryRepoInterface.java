package com.shoppingApp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.app.entity.Category;

public interface CategoryRepoInterface extends JpaRepository<Category,Integer> {

}
