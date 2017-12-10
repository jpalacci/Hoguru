package model;

public class Person {


    private String email;
    private String name;
    private String surname;
    private DOCUMENT_TYPE docType;
    private String document;
    private Address address ;
    private String phoneNumber;
    private PHONE_TYPE phoneType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return document.equals(person.document);
    }

    @Override
    public int hashCode() {
        return document.hashCode();
    }

    public Person(String email, String name, String surname, String document) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
    }

    public Person(String email, String name, String surname, DOCUMENT_TYPE docType, String document, Address adress, String phoneNumber, PHONE_TYPE phoneType) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.docType = docType;
        this.document = document;
        this.address = adress;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DOCUMENT_TYPE getDocType() {
        return docType;
    }

    public void setDocType(DOCUMENT_TYPE docType) {
        this.docType = docType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Address getAdress() {
        return address;
    }

    public void setAdress(Address adress) {
        this.address = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PHONE_TYPE getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PHONE_TYPE phoneType) {
        this.phoneType = phoneType;
    }


}

