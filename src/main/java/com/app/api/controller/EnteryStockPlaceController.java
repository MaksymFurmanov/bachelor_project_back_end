package com.app.api.controller;

import com.app.api.model.EnteryStockPlace;
import com.app.service.EnteryStockPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnteryStockPlaceController {
    private final EnteryStockPlaceService enteryStockPlaceService;

    @Autowired
    public EnteryStockPlaceController(EnteryStockPlaceService enteryStockPlaceService) {
        this.enteryStockPlaceService = enteryStockPlaceService;
    }

    @GetMapping("/entery-stock-places/get-entery-stock-places")
    public ResponseEntity<List<EnteryStockPlace>> getEnteryStockPlaces() {
        List<EnteryStockPlace> enteryStockPlaces = enteryStockPlaceService.getEnteryStockPlaces();
        if(enteryStockPlaces != null) return ResponseEntity.ok(enteryStockPlaces);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/entery-stock-places/load-entery-stock-places")
    public ResponseEntity<Void> loadEnteryStockPlaces(@RequestBody() EnteryStockPlace[] enteryStockPlaces) {
        enteryStockPlaceService.loadEnteryStockPlaces(enteryStockPlaces);
        return ResponseEntity.ok(null);
    }
}
