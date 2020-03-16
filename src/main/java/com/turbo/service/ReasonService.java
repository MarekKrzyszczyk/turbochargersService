package com.turbo.service;

import com.turbo.model.Part;
import com.turbo.model.Reason;
import com.turbo.repository.PartRepository;
import com.turbo.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonService {
    private ReasonRepository reasonRepository;

    @Autowired
    public ReasonService(ReasonRepository reasonRepository) {
        this.reasonRepository = reasonRepository;
    }

    public List<Reason> getAllParts(){
       return reasonRepository.findAll();
    }
}
