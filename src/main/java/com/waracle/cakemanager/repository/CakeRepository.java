package com.waracle.cakemanager.repository;

import com.waracle.cakemanager.domain.Cake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends CrudRepository<Cake, Long> {
}
