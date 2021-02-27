package com.learning.service;

import com.learning.exeptions.ResourceNotFoundException;
import com.learning.model.DrivingLicense;
import com.learning.repo.DrivingLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrivingLicenseService {

    @Autowired
    private DrivingLicenseRepository drivingLicenseRepository;

    public DrivingLicense findById(Integer id) {
        return drivingLicenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drivign license with id " + id + " was not found"));
    }
}
