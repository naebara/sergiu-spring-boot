package com.learning.controller;

import com.learning.dto.DrivingLicenseDto;
import com.learning.mapper.DrivingLicenseMapper;
import com.learning.mapper.PersonMapper;
import com.learning.model.DrivingLicense;
import com.learning.service.DrivingLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/drivingLicenses")
public class DrivingLicenseController {

    @Autowired
    private DrivingLicenseService drivingLicenseService;

    @Autowired
    private DrivingLicenseMapper mapper;

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/findById/{id}")
    public DrivingLicenseDto getLicenseById(@PathVariable("id") Integer licenseId) {
        DrivingLicense drivingLicense = drivingLicenseService.findById(licenseId);
        DrivingLicenseDto dto = mapper.mapToDto(drivingLicense);
        dto.setOwner(personMapper.mapToDto(drivingLicense.getOwner()));
        return dto;
    }

}

