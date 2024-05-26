package com.jeongsu.moni.repository;

import com.jeongsu.moni.model.CpuUsage;
import com.jeongsu.moni.model.MemoryUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoryUsageRepository extends JpaRepository<MemoryUsage, Long> {
}