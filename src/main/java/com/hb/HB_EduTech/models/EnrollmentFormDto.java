package com.hb.HB_EduTech.models;

import com.hb.HB_EduTech.entities.EnrollmentPackage;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnrollmentFormDto {
    public Long id;
    public String name;
    public Long whatsappNumber;
    public Long contactNumber;
    public String emailAddress;
    public ArrayList<String> enrolledExams;
    public ArrayList<String> Category;
    public String fathersName;
    public Long fathersContactNumber;
    public String mothersName;
    public Long mothersContactNumber;
    public String docPath;
    public EnrollmentPackage enrollmentPackage;
    public Boolean paymentSuccess;
    public String paymentMethod;
}
