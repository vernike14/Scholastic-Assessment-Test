package com.precize.sat.controller;

import com.precize.sat.modal.SatResultModel;
import com.precize.sat.service.SatResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/api/satResults")
public class SatResultController {

    @Autowired
    private SatResultService satResultService;

    @GetMapping("/getAllResults")
    public ResponseEntity<List<SatResultModel>> getAllResults(){
        List<SatResultModel> satResultModels = satResultService.getAllResults();
        return ResponseEntity.ok(satResultModels);
    }

    @PostMapping
    public ResponseEntity<SatResultModel> saveResults(@RequestBody SatResultModel satResultModel){
        satResultModel = satResultService.saveResult(satResultModel);
        if(Objects.isNull(satResultModel)){
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(satResultModel, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SatResultModel> getByName(@PathVariable String name){
        SatResultModel satResultModel = satResultService.getByName(name);
        if(Objects.isNull(satResultModel)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(satResultModel, HttpStatus.OK);
    }

    @PutMapping("/{name}/{updatedScore}")
    public ResponseEntity<SatResultModel> updateScoreByName(@PathVariable String name, @PathVariable double updatedScore){
        SatResultModel satResultModel = satResultService.updateScore(name, updatedScore);
        if(Objects.isNull(satResultModel)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(satResultModel, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteResult(@PathVariable String name){
        boolean result = satResultService.deleteByName(name);
        if(result){
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }


}
