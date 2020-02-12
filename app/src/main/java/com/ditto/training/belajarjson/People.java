package com.ditto.training.belajarjson;

import java.util.ArrayList;

public class People {
    String name;
    String age;
    String gender;
    ArrayList<Alamat> address;

    public People(String name, String age, String gender, ArrayList<Alamat> address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<Alamat> getAddress() {
        return address;
    }

    public static class Alamat {
        String nameAddres;
        String detailAddress;
        String city;

        public Alamat(String nameAddres, String detailAddress, String city) {
            this.nameAddres = nameAddres;
            this.detailAddress = detailAddress;
            this.city = city;
        }

        public String getNameAddres() {
            return nameAddres;
        }

        public String getDetailAddress() {
            return detailAddress;
        }

        public String getCit() {
            return city;
        }
    }
}
