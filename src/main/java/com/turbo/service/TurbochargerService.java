package com.turbo.service;

import com.turbo.model.Turbocharger;
import com.turbo.repository.TurbochargerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurbochargerService {

    private TurbochargerRepository turbochargerRepository;

    @Autowired
    public TurbochargerService(TurbochargerRepository turbochargerRepository) {
        this.turbochargerRepository = turbochargerRepository;
    }

    public List<Turbocharger> getAllTurbos() {
        return turbochargerRepository.findAll();
    }

    public void addTurbo(String number, String model, String producer) {
        Turbocharger turbocharger = new Turbocharger(number, model, producer);
        turbochargerRepository.save(turbocharger);
    }

    public void deleteTurbo(Integer id) {
        turbochargerRepository.deleteById(id);
    }

    public void updateTurbo(Turbocharger turbocharger) {
            Turbocharger turbo = findTurboById(turbocharger.getId());
            turbo.setNumber(turbocharger.getNumber());
            turbo.setModel(turbocharger.getModel());
            turbo.setProducer(turbocharger.getProducer());
            turbochargerRepository.save(turbo);
        }

    public Turbocharger findTurboById(Integer id) {
        Optional<Turbocharger> optTurbo = turbochargerRepository.findById(id);
        if (optTurbo.isPresent()) {
            Turbocharger turbo = optTurbo.get();
            return turbo;
        }
        return optTurbo.orElse(new Turbocharger());
    }

}
