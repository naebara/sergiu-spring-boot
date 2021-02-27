package com.learning.repo;

import com.learning.model.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Integer> {
    
}
