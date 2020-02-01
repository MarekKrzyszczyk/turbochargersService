package com.turbo.turbocharges;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TurbochargerRepository extends JpaRepository<Turbocharger, Integer> {
}
