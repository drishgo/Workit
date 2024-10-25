package com.Workit.Workit.model;

import jakarta.persistence.*;

@Entity
public class Profile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne
    @JoinColumn(name = "username",referencedColumnName = "username", unique = true)
    private Users users;
    private String bio;
    private String Organisation;
    private String Designation;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getOrganisation() {
        return Organisation;
    }

    public void setOrganisation(String organisation) {
        Organisation = organisation;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
