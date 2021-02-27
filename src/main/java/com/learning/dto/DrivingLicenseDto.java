package com.learning.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.enums.DrivingLicenseCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrivingLicenseDto {

    private int id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releasedAt;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expireDate;

    private DrivingLicenseCategory category;

    private String image;

    private String releasedBy;

    private PersonDto owner;

    public DrivingLicenseDto(int id, LocalDate releasedAt, LocalDate expireDate, DrivingLicenseCategory category, String image, String releasedBy) {
        this.id = id;
        this.releasedAt = releasedAt;
        this.expireDate = expireDate;
        this.category = category;
        this.image = image;
        this.releasedBy = releasedBy;
    }
}
