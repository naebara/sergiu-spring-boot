package com.learning.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.enums.DrivingLicenseCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driving_licenses")
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releasedAt;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expireDate;

    private DrivingLicenseCategory category;

    private String image;
    
    private String releasedBy;

    @OneToOne(mappedBy = "drivingLicense")
    private Person owner;


}
