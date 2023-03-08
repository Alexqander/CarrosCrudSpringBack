package com.mx.sda.carroscrudspring.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRepository extends JpaRepository<Coche,Long> {
    Coche findById(long id);
    List<Coche> findAllByStatus_id(long id);


}
