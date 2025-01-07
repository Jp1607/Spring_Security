package com.jp.Spring_Security.Model.Repository;

import com.jp.Spring_Security.Model.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public @Repository interface CarRepository extends JpaRepository<Car, Long> {
}
