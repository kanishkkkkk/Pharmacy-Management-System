package com.pharmacy.usermanagement.controller;

import com.pharmacy.usermanagement.services.Email.EmailSenderService;
import com.pharmacy.usermanagement.entity.Admin;
import com.pharmacy.usermanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmailSenderService senderService;

    @GetMapping("/admin")
    public ResponseEntity getAdmin(){
        try {
            return ResponseEntity.ok(adminService.getAdmin());
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("no admin found");
        }
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity getAdminById(@PathVariable("adminId") String id){
        try {
            return ResponseEntity.ok(adminService.findAdminById(id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("no admin found");
        }
    }

    @PostMapping("/admin")
    public ResponseEntity createAdmin(@RequestBody Admin admin) {
        try {
            ResponseEntity.status(HttpStatus.CREATED)
                    .body(adminService.saveAdmin(admin));

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body( senderService.sendSimpleEmail(admin.getAdmin_email(),
                            "PHARMACARE: New Account Created ",
                            "Hey " + admin.getAdmin_name()+"      " +
                                    "You have created an account on Pharmacare as admin."));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Admin not created. Check the inputs.");
        }
    }

    @PutMapping("/admin/{adminId}")
    public ResponseEntity updateAdmin(@RequestBody Admin admin,@PathVariable("adminId") String id){

        try {
            return ResponseEntity.ok(adminService.updateAdmin(admin,id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Admin with id "+id+" not found in the System");
        }
    }

    @DeleteMapping("/admin/{adminId}")
    public  ResponseEntity deleteAdmin(@PathVariable("adminId") String id){
        try {
            return ResponseEntity.ok(adminService.deleteAdmin(id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Admin with id "+id+" not found in the System");
        }
    }
}
