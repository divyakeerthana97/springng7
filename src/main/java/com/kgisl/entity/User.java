package com.kgisl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private int active;

   /**
    * @return the id
    */
   public int getId() {
       return id;
   }/**
    * @param id the id to set
    */
   public void setId(int id) {
       this.id = id;
   }/**
    * @return the email
    */
   public String getEmail() {
       return email;
   }/**
    * @param email the email to set
    */
   public void setEmail(String email) {
       this.email = email;
   }/**
    * @return the name
    */
   public String getName() {
       return name;
   }/**
    * @param name the name to set
    */
   public void setName(String name) {
       this.name = name;
   }/**
    * @return the lastname
    */
   public String getLastname() {
       return lastname;
   }/**
    * @param lastname the lastname to set
    */
   public void setLastname(String lastname) {
       this.lastname = lastname;
   }/**
    * @return the active
    */
   public int getActive() {
       return active;
   }/**
    * @param active the active to set
    */
   public void setActive(int active) {
       this.active = active;
   }
   /**
    * @return the password
    */
   public String getPassword() {
       return password;
   }
   /**
    * @param password the password to set
    */
   public void setPassword(String password) {
       this.password = password;
   }
}