package com.pharmacy.drugmanagement.controller;

import com.pharmacy.drugmanagement.Entity.Drug;
import com.pharmacy.drugmanagement.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping("/drug")
    public ResponseEntity getDrug() {
        try {
            return ResponseEntity.ok(drugService.getDrug());
        } catch (Exception e) {
            e.printStackTrace();
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No drug found");
        }
    }

    @PostMapping("/drug")
    public ResponseEntity createDrug(@RequestBody Drug drug) {
        try {
            return ResponseEntity.ok(drugService.saveDrug(drug));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No drug created");
        }
    }
//wsp sum
    @PutMapping("/drug/{drugId}")
    public ResponseEntity updateDrug(@RequestBody Drug drug, @PathVariable("drugId") String id) {
        try {
            return ResponseEntity.ok(drugService.updateDrug(drug,id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No drug found");
        }
    }

    @DeleteMapping("/drug/{drugId}")
    public ResponseEntity deleteDrug(@PathVariable("drugId") String id) {
        try {
            return ResponseEntity.ok(drugService.deleteDrug(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No drug found");
        }
    }
}



