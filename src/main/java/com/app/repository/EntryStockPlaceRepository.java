package com.app.repository;

import com.app.api.model.EntryStockPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryStockPlaceRepository extends JpaRepository<EntryStockPlace, Long> {}
