package com.example.spring_mysql.repository;

import com.example.spring_mysql.model.Poistenec;
import com.example.spring_mysql.model.PoistenieCestovne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CestovnePoistenieRepository extends JpaRepository<PoistenieCestovne, Long> {
}
