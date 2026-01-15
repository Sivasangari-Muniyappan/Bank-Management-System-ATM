CREATE DATABASE bankmanagementsystem;
USE bankmanagementsystem;

CREATE TABLE signup (
    Form_No VARCHAR(20),
    Name VARCHAR(20),
    Father_Name VARCHAR(20),
    DOB VARCHAR(20),
    Gender VARCHAR(20),
    Email VARCHAR(30),
    Marital_Status VARCHAR(20),
    Address VARCHAR(50),
    City VARCHAR(20),
    Pincode VARCHAR(20),
    State VARCHAR(20)
);

CREATE TABLE signuptwo (
    Form_No VARCHAR(20),
    Religion VARCHAR(20),
    Category VARCHAR(20),
    Income VARCHAR(20),
    Qualification VARCHAR(20),
    Occupation VARCHAR(20),
    Pan_Number VARCHAR(20),
    Aadhar VARCHAR(20),
    Senior_Citizen VARCHAR(20),
    Existing_Account VARCHAR(20)
);

CREATE TABLE signupthree (
    Form_No VARCHAR(20),
    Account_Type VARCHAR(40),
    Card_Number VARCHAR(20),
    Pin VARCHAR(20),
    Facility VARCHAR(100)
);

CREATE TABLE login (
    Form_No VARCHAR(20),
    Card_Number VARCHAR(20),
    Pin VARCHAR(20)
);

CREATE TABLE bank (
    Pin VARCHAR(10),
    Date VARCHAR(50),
    Type VARCHAR(20),
    Amount VARCHAR(20)
);
