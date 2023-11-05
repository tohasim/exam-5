package com.example.exam5syncandasync.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    String name;
    String gender;
    int genderProbability;
    int age;
    int ageCount;
    String country;
    int countryProbability;

    public Response(Gender genderDto, Age ageDto, Nation nationDto) {
        this.name = genderDto.getName();
        this.gender = genderDto.getGender();
        double genderProbDouble = genderDto.getProbability()*100;
        this.genderProbability = (int) genderProbDouble;
        this.age = ageDto.getAge();
        this.ageCount = ageDto.getCount();
        this.country = nationDto.getCountry().get(0).getCountry_id();
        double countryProbDouble = nationDto.getCountry().get(0).getProbability()*100;
        this.countryProbability = (int) countryProbDouble ;
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", genderProbability=" + genderProbability +
                ", age=" + age +
                ", ageCount=" + ageCount +
                ", country='" + country + '\'' +
                ", countryProbability=" + countryProbability +
                '}';
    }
}
