package com.example.test;

import com.example.test.entity.Counter;
import com.example.test.repository.CounterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CounterRepository counterRepository) {
        return (args) -> {
            counterRepository.save(new Counter(1l, 50l));
        };
    }

}
