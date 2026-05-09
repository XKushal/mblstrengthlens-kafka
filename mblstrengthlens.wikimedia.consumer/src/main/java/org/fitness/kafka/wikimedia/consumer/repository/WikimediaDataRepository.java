package org.fitness.kafka.wikimedia.consumer.repository;

import org.fitness.kafka.wikimedia.consumer.entity.WikimediaObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaObj, Long> {
}
