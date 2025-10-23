package com.iancode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SoftwareEngineerRepository
        extends JpaRepository<SoftwareEngineer, Integer> {

    Optional<SoftwareEngineer> findByName(String name);
}
