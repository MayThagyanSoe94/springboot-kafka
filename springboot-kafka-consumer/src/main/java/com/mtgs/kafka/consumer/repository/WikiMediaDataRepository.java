package com.mtgs.kafka.consumer.repository;

import com.mtgs.kafka.consumer.entity.WikiMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaDataRepository extends JpaRepository<WikiMedia,Long> {
}
