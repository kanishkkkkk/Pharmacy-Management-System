package com.pharmacy.usermanagement.controller;

import com.pharmacy.usermanagement.entity.Doctor;
import com.pharmacy.usermanagement.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/doctor")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok(doctorService.getDoctor());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No doctor found");
        }
    }

    @PostMapping("/doctor")
    public ResponseEntity createDoctor(@RequestBody Doctor doctor) {
        try {
            return ResponseEntity.ok(doctorService.saveDoctor(doctor));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Doctor not created");
        }

    }

    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity updateUser(@RequestBody Doctor doctor, @PathVariable("doctorId") String id) {

        try {
            return ResponseEntity.ok(doctorService.updateDoctor(doctor, id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor with id " + id + " not found");
        }
    }

    @DeleteMapping("/doctor/{doctorId}")
    public ResponseEntity deleteDoctor(@PathVariable("doctorId") String id) {

        try {
            return ResponseEntity.ok(doctorService.deleteDoctor(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Admin not found");
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity findDoctorById(@PathVariable("doctorId") String id) {
        try {
            return ResponseEntity.ok(doctorService.findDoctorById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No doctor found");
        }
    }
}
