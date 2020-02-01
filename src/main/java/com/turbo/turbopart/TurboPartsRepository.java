package com.turbo.turbopart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurboPartsRepository extends JpaRepository<TurboPart, Integer> {
}
