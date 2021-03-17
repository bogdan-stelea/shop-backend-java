package ro.bogdan.shopspring.models;

import java.util.Random;

public class Client {
    private final String clientCode;
    private PersonalData personalData;
    Random rand = new Random();

    public Client() {
        this.clientCode = String.valueOf(rand.nextInt(10000));
    }

    public Client(PersonalData personalData) {
        this.clientCode = String.valueOf(rand.nextInt(10000));
        this.personalData = personalData;
    }

    public String getClientCode() {
        return clientCode;
    }

    public static class PersonalData {
        private String lastname;
        private String surname;
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
