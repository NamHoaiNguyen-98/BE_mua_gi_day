package com.example.tmdt.repository;

import com.example.tmdt.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
