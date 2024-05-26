package com.jeongsu.moni.repository;

import com.jeongsu.moni.model.ProcessStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessStatusRepository extends JpaRepository<ProcessStatus, Long> {
}