package com.project.demo.repository.jpa.dohwan;

import com.project.demo.domain.SnsAuthorizationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnsAuthorizationDateRepo extends JpaRepository<SnsAuthorizationData, Integer> {
}
