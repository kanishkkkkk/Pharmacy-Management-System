package com.pharmacy.usermanagement.services;

import com.pharmacy.usermanagement.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {


    public List<Admin> getAdmin();

    public Admin saveAdmin(Admin admin);

    public Admin updateAdmin(Admin admin, String id);

    public String deleteAdmin(String id);

    public Optional<Admin> findAdminById(String id);
}
