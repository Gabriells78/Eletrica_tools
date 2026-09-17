package com.electrical.demo.repository;

import com.electrical.demo.Motor.Motor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface motorRepository  extends JpaRepository<Motor, Long> {
}
