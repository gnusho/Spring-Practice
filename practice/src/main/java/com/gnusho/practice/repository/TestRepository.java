package com.gnusho.practice.repository;

import com.gnusho.practice.domain.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<A, Long> {


}
