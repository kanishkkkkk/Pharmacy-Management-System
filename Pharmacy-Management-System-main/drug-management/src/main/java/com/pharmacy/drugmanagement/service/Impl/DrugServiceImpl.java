package com.pharmacy.drugmanagement.service.Impl;

import com.pharmacy.drugmanagement.Entity.Drug;
import com.pharmacy.drugmanagement.dao.DrugRespository;
import com.pharmacy.drugmanagement.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRespository drugRepository;

    @Override
    public List<Drug> getDrug() {
        List<Drug> drug = drugRepository.findAll();
        return drug;
    }

    @Override
    public Drug saveDrug(Drug drug) {
        Drug drugs = drugRepository.save(drug);
        return drugs;
    }

    @Override
    public Drug updateDrug(Drug drug,String id) {
        Drug d = drugRepository.findById(id).get();
        d.setDrug_ID(id);
        d.setDrug_Name(drug.getDrug_Name());
        d.setDrug_Quantity(drug.getDrug_Quantity());
        d.setBatch_ID(drug.getBatch_ID());
        d.setPrice(drug.getPrice());
        d.setExpiry_date(drug.getExpiry_date());
        drugRepository.save(d);
        return d;
    }

    @Override
    public String deleteDrug(String id) {
        drugRepository.deleteById(id);
        return id;
    }
}