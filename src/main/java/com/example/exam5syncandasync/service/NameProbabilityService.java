package com.example.exam5syncandasync.service;

import com.example.exam5syncandasync.dtos.Age;
import com.example.exam5syncandasync.dtos.Gender;
import com.example.exam5syncandasync.dtos.Nation;
import com.example.exam5syncandasync.dtos.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;


@Service
public class NameProbabilityService {
    public Response getProbabilities(String name) {
        var gender = getGenderForName(name);
        var age = getAgeForName(name);
        var nation = getNationForName(name);
        var rs = Mono.zip(gender, age, nation).map(tuple3 -> {
            var monos = new ArrayList<>();
            monos.add(tuple3.getT1());
            monos.add(tuple3.getT2());
            monos.add(tuple3.getT3());
            return monos;
        });
        var blockedMonos = rs.block();
        assert blockedMonos != null;
        Response res = new Response((Gender) blockedMonos.get(0), (Age) blockedMonos.get(1), (Nation) blockedMonos.get(2));
        System.out.println(res);
        return res;
    }


    Mono<Gender> getGenderForName(String name) {
        WebClient client = WebClient.create();
        Mono<Gender> gender = client.get()
                .uri("https://api.genderize.io?name="+name)
                .retrieve()
                .bodyToMono(Gender.class);
        return gender;
    }
    Mono<Age> getAgeForName(String name){
        WebClient client = WebClient.create();
        Mono<Age> age = client.get()
                .uri("https://api.agify.io/?name="+name)
                .retrieve()
                .bodyToMono(Age.class);
        return age;
    }
    Mono<Nation> getNationForName(String name){
        WebClient client = WebClient.create();
        Mono<Nation> nation = client.get()
                .uri("https://api.nationalize.io/?name="+name)
                .retrieve()
                .bodyToMono(Nation.class);
        return nation;
    }
}
