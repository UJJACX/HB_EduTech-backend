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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(Long whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<String> getEnrolledExams() {
        return enrolledExams;
    }

    public void setEnrolledExams(ArrayList<String> enrolledExams) {
        this.enrolledExams = enrolledExams;
    }

    public ArrayList<String> getCategory() {
        return Category;
    }

    public void setCategory(ArrayList<String> category) {
        Category = category;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public Long getFathersContactNumber() {
        return fathersContactNumber;
    }

    public void setFathersContactNumber(Long fathersContactNumber) {
        this.fathersContactNumber = fathersContactNumber;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public Long getMothersContactNumber() {
        return mothersContactNumber;
    }

    public void setMothersContactNumber(Long mothersContactNumber) {
        this.mothersContactNumber = mothersContactNumber;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public EnrollmentPackage getEnrollmentPackage() {
        return enrollmentPackage;
    }

    public void setEnrollmentPackage(EnrollmentPackage enrollmentPackage) {
        this.enrollmentPackage = enrollmentPackage;
    }

    public Boolean getPaymentSuccess() {
        return paymentSuccess;
    }

    public void setPaymentSuccess(Boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
