package com.pharmacy.suppliermanagement.service.Impl;

import com.pharmacy.suppliermanagement.Entitty.Supplier;
import com.pharmacy.suppliermanagement.dao.SupplierRepository;
import com.pharmacy.suppliermanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getSupplier() {
        List<Supplier> supplier = supplierRepository.findAll();
        return supplier;
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        Supplier suppliers = supplierRepository.save(supplier);
        return suppliers;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier,String id) {
        Supplier s = supplierRepository.findById(id).get();
        s.setSupplier_Id(id);
        s.setSupplier_name(supplier.getSupplier_name());
        s.setSupplier_contact(supplier.getSupplier_contact());
        s.setSupplier_email(supplier.getSupplier_email());
        supplierRepository.save(s);
        return s;
    }

    @Override
    public String deleteSupplier(String id) {
        supplierRepository.deleteById(id);
        return id;
    }
}

