package com.turbo.reason;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("reasons")
public class ReasonServlet {
    private final Logger logger = LoggerFactory.getLogger(ReasonServlet.class);
    private ReasonRepository repository;

    public ReasonServlet(ReasonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Reason>> findAllReasons() {
        logger.info("Got request");
        return ResponseEntity.ok(repository.findAll());
    }

}
