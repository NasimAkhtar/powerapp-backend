package com.nikka.powerapp.dao.repository;

import com.nikka.powerapp.dao.model.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainsRepository extends JpaRepository<Complain, Long> {

}
