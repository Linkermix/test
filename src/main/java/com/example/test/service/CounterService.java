package com.example.test.service;

import com.example.test.entity.Counter;
import com.example.test.repository.CounterRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CounterService {

    @Autowired
    CounterRepository counterRepository;

    public Counter getValue() {

        return counterRepository.findById(1L).get();

    }

    public void updateValue(Long value) {
        counterRepository.save(new Counter(1l,value));
    }



}
