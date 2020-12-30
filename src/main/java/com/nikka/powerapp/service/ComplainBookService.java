package com.nikka.powerapp.service;

import com.nikka.powerapp.dao.model.Complain;
import com.nikka.powerapp.dao.repository.ComplainsRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ComplainBookService {

    private ComplainsRepository complainsRepository;

    ComplainBookService(ComplainsRepository complainsRepository) {
        this.complainsRepository = complainsRepository;
    }

    public List<Complain> getAllComplains() {
        List<Complain> complains = complainsRepository.findAll();
        complains.sort(Comparator.comparing(Complain::getId).reversed());
        return complains;
    }

    public Complain addComplain(Complain complain) {
        Complain savedComplain = complainsRepository.saveAndFlush(complain);
        return savedComplain;
    }

    public Complain updateComplain(Complain complain) {
        return complainsRepository.save(complain);
    }
}
