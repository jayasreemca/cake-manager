package com.waracle.cakemanager.service;

import com.waracle.cakemanager.domain.Cake;
import com.waracle.cakemanager.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {
    private CakeRepository cakeRepository;

    @Autowired
    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public Iterable<Cake> list() {
        return cakeRepository.findAll();
    }

    public Iterable<Cake> save(List<Cake> cakes) {
        return cakeRepository.saveAll(cakes);
    }

    public Cake addCake(Cake cake) {
        return cakeRepository.save(cake);
    }
}
