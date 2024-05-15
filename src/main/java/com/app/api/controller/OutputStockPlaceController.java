package com.app.api.controller;

import com.app.api.model.OutputStockPlace;
import com.app.service.OutputStockPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output-stock-places")
public class OutputStockPlaceController {
    private final OutputStockPlaceService outputStockPlaceService;

    @Autowired
    public OutputStockPlaceController(OutputStockPlaceService outputStockPlaceService) {
        this.outputStockPlaceService = outputStockPlaceService;
    }

    @GetMapping("")
    public ResponseEntity<List<OutputStockPlace>> getOutputStockPlaces() {
        List<OutputStockPlace> outputStockPlaces = outputStockPlaceService.getOutputStockPlaces();
        if (outputStockPlaces != null) return ResponseEntity.ok(outputStockPlaces);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<List<OutputStockPlace>>
    uploadOutputStockPlaces(@RequestBody() OutputStockPlace[] outputStockPlaces) {
        return ResponseEntity.ok(outputStockPlaceService.uploadOutputStockPlaces(outputStockPlaces));
    }
}
