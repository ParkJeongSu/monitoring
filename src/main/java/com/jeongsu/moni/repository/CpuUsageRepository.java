package com.jeongsu.moni.repository;

import com.jeongsu.moni.model.CpuUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuUsageRepository extends JpaRepository<CpuUsage, Long> {
}