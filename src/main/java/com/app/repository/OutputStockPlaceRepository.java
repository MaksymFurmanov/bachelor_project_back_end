package com.app.repository;

import com.app.api.model.OutputStockPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputStockPlaceRepository extends JpaRepository<OutputStockPlace, Long> {
}
