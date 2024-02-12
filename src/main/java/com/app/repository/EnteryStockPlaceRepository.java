package com.app.repository;

import com.app.api.model.EnteryStockPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnteryStockPlaceRepository extends JpaRepository<EnteryStockPlace, Long> {}
