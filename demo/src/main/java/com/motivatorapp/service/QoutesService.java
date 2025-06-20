package com.motivatorapp.service;

import com.motivatorapp.repository.QouteRepository;
import org.springframework.stereotype.Service;

@Service
public class QoutesService {

    private QouteRepository qouteRepository;

    public QoutesService(QouteRepository qouteRepository) {
        this.qouteRepository = qouteRepository;

    }

    public String provideQoute() {
        return qouteRepository.getRandomQoute();
    }

}
