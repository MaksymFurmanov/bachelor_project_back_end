package com.app.api.controller;

import com.app.api.model.OutputStockPlace;
import com.app.service.OutputStockPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutputStockPlaceController {
    private final OutputStockPlaceService outputStockPlaceService;

    @Autowired
    public OutputStockPlaceController(OutputStockPlaceService outputStockPlaceService) {
        this.outputStockPlaceService = outputStockPlaceService;
    }

    @GetMapping("/output-stock-places/get-output-stock-places")
    public ResponseEntity<List<OutputStockPlace>> getOutputStockPlaces() {
        List<OutputStockPlace> outputStockPlaces = outputStockPlaceService.getOutputStockPlaces();
        if(outputStockPlaces != null) return ResponseEntity.ok(outputStockPlaces);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/output-stock-places/load-output-stock-places")
    public ResponseEntity<Void> loadOutputStockPlaces(@RequestBody() OutputStockPlace[] outputStockPlaces) {
        outputStockPlaceService.loadOutputStockPlaces(outputStockPlaces);
        return ResponseEntity.ok(null);
    }
}
