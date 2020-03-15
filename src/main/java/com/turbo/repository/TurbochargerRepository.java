package com.turbo.repository;

import com.turbo.model.Turbocharger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurbochargerRepository extends JpaRepository<Turbocharger, Integer> {

}
