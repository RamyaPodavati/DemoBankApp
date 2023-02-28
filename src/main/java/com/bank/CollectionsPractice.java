package com.bank;

import com.example.BankApp2.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsPractice {
    public void main(String[] args) {

        User user1 = new User(1, "abc", "25");
        User user2 = new User(2, "xyz", "30");
        User user3 = new User(3, "aer", "20");
        User user4 = new User(4, "sgs", "35");
        User user5 = new User(5, "sdf", "40");
        User user6 = new User(6, "wagz", "50");

        Set<User> s = new HashSet<>();
        s.add(user1);
        s.add(user2);
        s.add(user3);
        s.add(user4);
        s.add(user5);
        s.add(user6);

        System.out.println(s);

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);
        result.forEach(str -> System.out.println(str));

    }
}
