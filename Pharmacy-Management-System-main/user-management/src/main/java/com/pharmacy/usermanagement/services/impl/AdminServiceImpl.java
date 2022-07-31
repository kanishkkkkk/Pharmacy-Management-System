package com.pharmacy.usermanagement.services.impl;

import com.pharmacy.usermanagement.dao.AdminRepository;
import com.pharmacy.usermanagement.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pharmacy.usermanagement.entity.Admin;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAdmin() {
        List<Admin> admin = adminRepository.findAll();
        return admin;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        Admin admins = adminRepository.save(admin);
        return admins;
    }

    @Override
    public Admin updateAdmin(Admin admin,String id) {

        Admin a = adminRepository.findById(id).get();
            a.setAdmin_Id(id);
            a.setAdmin_password(admin.getAdmin_password());
            a.setAdmin_contact(admin.getAdmin_contact());
            a.setAdmin_email(admin.getAdmin_email());
            a.setAdmin_name(admin.getAdmin_name());
            adminRepository.save(a);
        return a;
    }

    @Override
    public String deleteAdmin(String id) {
        adminRepository.deleteById(id);
        return id;
    }

    public Optional<Admin> findAdminById(String id){
        Optional<Admin> a = adminRepository.findById(id);
        return a;
    }
}
