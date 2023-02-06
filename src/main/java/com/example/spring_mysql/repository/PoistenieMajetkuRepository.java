package com.example.spring_mysql.repository;

import com.example.spring_mysql.model.PoistenieMajetku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PoistenieMajetkuRepository extends JpaRepository<PoistenieMajetku, Long> {

}
