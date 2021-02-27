package com.learning.mapper;

import com.learning.dto.DrivingLicenseDto;
import com.learning.model.DrivingLicense;
import org.springframework.stereotype.Component;

@Component
public class DrivingLicenseMapper {

    public DrivingLicenseDto mapToDto(DrivingLicense license) {
        return new DrivingLicenseDto(license.getId(), license.getReleasedAt(), license.getExpireDate(), license.getCategory(), license.getImage(), license.getReleasedBy());
    }

}
