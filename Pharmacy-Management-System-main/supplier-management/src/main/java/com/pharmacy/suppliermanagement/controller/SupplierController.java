package com.pharmacy.suppliermanagement.controller;

import com.pharmacy.suppliermanagement.Entitty.Supplier;
import com.pharmacy.suppliermanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/supplier")
    public ResponseEntity getSupplier() {
        try {
            return ResponseEntity.ok(supplierService.getSupplier());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No supplier found");
        }
    }

    @PostMapping("/supplier")
    public ResponseEntity createSupplier(@RequestBody Supplier supplier) {
        try {
            return ResponseEntity.ok(supplierService.saveSupplier(supplier));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No supplier created");
        }
    }

    @PutMapping("/supplier/{supplierId}")
    public ResponseEntity updateSupplier(@RequestBody Supplier supplier, @PathVariable("supplierId") String id) {
        try {
            return ResponseEntity.ok(supplierService.updateSupplier(supplier,id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No supplier found");
        }
    }

    @DeleteMapping("/supplier/{supplierId}")
    public ResponseEntity deleteSupplier(@PathVariable("supplierId") String id) {
        try {
            return ResponseEntity.ok(supplierService.deleteSupplier(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No supplier found");
        }
    }
}
    
