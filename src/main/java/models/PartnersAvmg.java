package models;

/**
 * Created by Дмитрий on 18.07.2017.
 */

import static models.FunctionBase.*;

public class PartnersAvmg {
    private String companyName;
    private String legalAdress;
    private String town;
    private String postalIndex;
    private String legalStatus;
    private String addressForDeliveryOfDocuments;
    private String placeOfdelivery;
    private String postalCodeOfDelivery;
    private String surname;
    private String name;
    private String position;
    private String mail;
    private String telephone;
    private String additionalTelephone;
    private String message;

    public PartnersAvmg() {

    }

    @Override
    public String toString() {
        return "PartnersAvmg{" +
                "companyName='" + companyName + '\'' +
                ", legalAdress='" + legalAdress + '\'' +
                ", town='" + town + '\'' +
                ", postalIndex='" + postalIndex + '\'' +
                ", legalStatus='" + legalStatus + '\'' +
                ", addressForDeliveryOfDocuments='" + addressForDeliveryOfDocuments + '\'' +
                ", placeOfdelivery='" + placeOfdelivery + '\'' +
                ", postalCodeOfDelivery='" + postalCodeOfDelivery + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", additionalTelephone='" + additionalTelephone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


    public PartnersAvmg(String companyName, String legalAdress, String town, String postalIndex, String legalStatus, String addressForDeliveryOfDocuments, String placeOfdelivery, String postalCodeOfDelivery, String surname, String name, String position, String mail, String telephone, String additionalTelephone, String message) {
        this.companyName = companyName;
        this.legalAdress = legalAdress;
        this.town = town;
        this.postalIndex = postalIndex;
        this.legalStatus = legalStatus;
        this.addressForDeliveryOfDocuments = addressForDeliveryOfDocuments;
        this.placeOfdelivery = placeOfdelivery;
        this.postalCodeOfDelivery = postalCodeOfDelivery;
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.telephone = telephone;
        this.additionalTelephone = additionalTelephone;
        this.message = message;
    }


    public static PartnersAvmg generate() {
        return new PartnersAvmg(
                generateRandomChars(10), generateRandomChars(10), getRandomTown(), generateRandomNumber(5),getRandomLegalStatus(),
                generateRandomChars(20), getRandomTown(), generateRandomNumber(5), generateRandomChars(12), generateRandomChars(8),
                generateRandomChars(15), getRandomMail(),   generateRandomNumber(9), generateRandomNumber(9), generateRandomChars(100));
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalAdress() {
        return legalAdress;
    }

    public void setLegalAdress(String legalAdress) {
        this.legalAdress = legalAdress;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostalIndex() {
        return postalIndex;
    }

    public void setPostalIndex(String postalIndex) {
        this.postalIndex = postalIndex;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getAddressForDeliveryOfDocuments() {
        return addressForDeliveryOfDocuments;
    }

    public void setAddressForDeliveryOfDocuments(String addressForDeliveryOfDocuments) {
        this.addressForDeliveryOfDocuments = addressForDeliveryOfDocuments;
    }

    public String getPlaceOfdelivery() {
        return placeOfdelivery;
    }

    public void setPlaceOfdelivery(String placeOfdelivery) {
        this.placeOfdelivery = placeOfdelivery;
    }

    public String getPostalCodeOfDelivery() {
        return postalCodeOfDelivery;
    }

    public void setPostalCodeOfDelivery(String postalCodeOfDelivery) {
        this.postalCodeOfDelivery = postalCodeOfDelivery;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdditionalTelephone() {
        return additionalTelephone;
    }

    public void setAdditionalTelephone(String additionalTelephone) {
        this.additionalTelephone = additionalTelephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
