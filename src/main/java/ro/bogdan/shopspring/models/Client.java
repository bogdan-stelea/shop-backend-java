package ro.bogdan.shopspring.models;

import java.util.Random;

public class Client {
    private  String clientCode;
    private PersonalData personalData;

    public Client() {

    }

    public Client(String clientCode,PersonalData personalData) {
        this.clientCode = clientCode;
        this.personalData = personalData;
    }

    public String getClientCode() {
        return clientCode;
    }

    public static class PersonalData {
        private final String lastname;
        private final String surname;
        private String phoneNumber;

        public PersonalData(String lastname, String surname, String phoneNumber) {
            this.lastname = lastname;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
        }

        public String getLastname() {
            return lastname;
        }

        public String getSurname() {
            return surname;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "PersonalData{" +
                    "lastname='" + lastname + '\'' +
                    ", surname='" + surname + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientCode='" + clientCode + '\'' +
                ", personalData=" + personalData +
                '}';
    }
}
