package com.ravems.finance_app.repository;

import com.ravems.finance_app.model.SpendingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingCategoryRepository extends JpaRepository <SpendingCategory, Long> {

    SpendingCategory findByName(String name);

}
