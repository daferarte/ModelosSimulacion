package com.gymtrack.gymtrackApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gymtrack.gymtrackApi.entities.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {
    
}
