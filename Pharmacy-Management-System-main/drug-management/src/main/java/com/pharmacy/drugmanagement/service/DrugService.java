package com.pharmacy.drugmanagement.service;

import com.pharmacy.drugmanagement.Entity.Drug;

import java.util.List;

public interface DrugService {
    public List<Drug> getDrug();

    public Drug saveDrug(Drug drug);

    public Drug updateDrug(Drug drug, String id);

    public String deleteDrug(String id);
}
