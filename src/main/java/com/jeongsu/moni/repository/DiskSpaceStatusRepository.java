package com.jeongsu.moni.repository;

import com.jeongsu.moni.model.DiskSpaceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiskSpaceStatusRepository extends JpaRepository<DiskSpaceStatus, Long> {
}