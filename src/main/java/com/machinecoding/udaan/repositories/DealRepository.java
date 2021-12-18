package com.machinecoding.udaan.repositories;

import com.machinecoding.udaan.models.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends CrudRepository<Deal, Integer> {
}
