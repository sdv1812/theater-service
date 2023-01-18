package com.sanskar.theater.performance

import com.sanskar.theater.model.Performance
import org.springframework.data.jpa.repository.JpaRepository

interface PerformanceRepository: JpaRepository<Performance, Long>
