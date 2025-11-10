package com.hb.HB_EduTech.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class EnrollmentForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long whatsappNumber;
    private Long contactNumber;
    private String emailAddress;
    private ArrayList<String> enrolledExams;
    private ArrayList<String> Category;
    private String fathersName;
    private Long fathersContactNumber;
    private String mothersName;
    private Long mothersContactNumber;
    private String docPath;

    @OneToOne
    @JoinColumn(name = "package_id")
    private EnrollmentPackage enrollmentPackage;

    private Boolean paymentSuccess;
    private String paymentMethod;
    private Date createdDate = new Date();

}
