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

    @GetMapping("/get-output-stock-places")
    public ResponseEntity<List<OutputStockPlace>> getOutputStockPlaces() {
        List<OutputStockPlace> outputStockPlaces = outputStockPlaceService.getOutputStockPlaces();
        if(outputStockPlaces != null) return ResponseEntity.ok(outputStockPlaces);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Void> newOutputStockPlace(@RequestBody() OutputStockPlace outputStockPlace) {
        if(outputStockPlace != null)outputStockPlaceService.newOutputStockPlace(outputStockPlace);
        else return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(null);
    }

    @PostMapping("/load-output-stock-places")
    public ResponseEntity<Void> loadOutputStockPlaces(@RequestBody() OutputStockPlace[] outputStockPlaces) {
        outputStockPlaceService.loadOutputStockPlaces(outputStockPlaces);
        return ResponseEntity.ok(null);
    }
}
