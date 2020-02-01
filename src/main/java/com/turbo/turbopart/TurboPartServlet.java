package com.turbo.turbopart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("turboparts")
public class TurboPartServlet {

    private final Logger logger = LoggerFactory.getLogger(TurboPartServlet.class);

    private TurboPartsRepository repository;

    public TurboPartServlet(TurboPartsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<TurboPart>> findAllTurboParts() {
        logger.info("Got request");
        return ResponseEntity.ok(repository.findAll());
    }

}
