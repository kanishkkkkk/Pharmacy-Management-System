package com.pharmacy.usermanagement.services.impl;

import com.pharmacy.usermanagement.dao.DoctorRepository;
import com.pharmacy.usermanagement.entity.Admin;
import com.pharmacy.usermanagement.entity.Doctor;
import com.pharmacy.usermanagement.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getDoctor() {
        List<Doctor> doctor= doctorRepository.findAll();
        return doctor;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Doctor doctors = doctorRepository.save(doctor);
//        Doctor doctors= new Doctor("id1","name1","emial1","pass1",1);
        return doctors;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor,String id) {
        Doctor a = doctorRepository.findById(id).get();
        a.setDoctor_Id(id);
        a.setDoctor_password(doctor.getDoctor_password());
        a.setDoctor_contact(doctor.getDoctor_contact());
        a.setDoctor_email(doctor.getDoctor_email());
        a.setDoctor_name(doctor.getDoctor_name());
        doctorRepository.save(a);
        return a;
    }

    @Override
    public String deleteDoctor(String id) {
        doctorRepository.deleteById(id);
        return id;
    }

    @Override
    public Optional<Doctor> findDoctorById(String id){
        Optional<Doctor> d = doctorRepository.findById(id);
        return d;
    }
}
