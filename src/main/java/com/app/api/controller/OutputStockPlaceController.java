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

    @PostMapping("/new")
    public ResponseEntity<OutputStockPlace> newOutputStockPlace(@RequestBody() OutputStockPlace outputStockPlace) {
        if (outputStockPlace == null) return ResponseEntity.badRequest().build();
        OutputStockPlace newOutputStockPlace = outputStockPlaceService.newOutputStockPlace(outputStockPlace);
        if(newOutputStockPlace != null) return ResponseEntity.ok(newOutputStockPlace);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/load-output-stock-places")
    public ResponseEntity<List<OutputStockPlace>>
    loadOutputStockPlaces(@RequestBody() OutputStockPlace[] outputStockPlaces) {
        return ResponseEntity.ok(outputStockPlaceService.loadOutputStockPlaces(outputStockPlaces));
    }
}
