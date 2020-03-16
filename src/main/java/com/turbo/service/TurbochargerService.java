package com.turbo.service;

import com.turbo.model.Turbocharger;
import com.turbo.repository.TurbochargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurbochargerService {

    private TurbochargerRepository turbochargerRepository;

    @Autowired
    public TurbochargerService(TurbochargerRepository turbochargerRepository) {
        this.turbochargerRepository = turbochargerRepository;
    }

    public List<Turbocharger> getAllTurbos(){
        return turbochargerRepository.findAll();
    }

    public void addTurbo(String number, String model, String producer){
        Turbocharger turbocharger = new Turbocharger(number, model, producer);
        turbochargerRepository.save(turbocharger);
    }

}
