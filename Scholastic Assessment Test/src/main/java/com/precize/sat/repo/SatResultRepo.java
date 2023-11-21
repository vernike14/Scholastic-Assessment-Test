package com.precize.sat.repo;

import com.precize.sat.entity.SatResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SatResultRepo extends JpaRepository<SatResults, Long> {

    @Query("SELECT s FROM SatResults s where s.name = ?1")
    public SatResults getSatResultsByName(String name);

}
