package com.fruityveggies.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruityveggies.www.repository.test.Test;
import com.fruityveggies.www.repository.test.TestRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;
    
    public List<Test> read(){
        log.info("read()={}");
        
        return testRepository.findByOrderByIdDesc();
    }
}
