package com.precize.sat.repo;

import com.precize.sat.entity.SatResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SatResultRepo extends JpaRepository<SatResults, Long> {

    @Query("SELECT s FROM SatResults s where s.name = ?1")
    public SatResults getSatResultsByName(String name);

    @Query("SELECT s FROM SatResults s ORDER BY s.score DESC")
    List<SatResults> findAllByScoreDesc();
}
