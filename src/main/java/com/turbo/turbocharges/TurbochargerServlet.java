package com.turbo.turbocharges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("turbochargers")
public class TurbochargerServlet {
    private final Logger logger = LoggerFactory.getLogger(TurbochargerServlet.class);

    private TurbochargerRepository repository;

    TurbochargerServlet(TurbochargerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Turbocharger>> findAllTurboChargers() {
        logger.info("Got request");
        return ResponseEntity.ok(repository.findAll());
    }
}
