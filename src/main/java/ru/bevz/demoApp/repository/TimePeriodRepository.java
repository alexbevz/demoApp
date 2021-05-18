package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.TimePeriod;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface TimePeriodRepository extends JpaRepository<TimePeriod, Long> {

	@Query(value = "select * from time_period where from_time = ?1 and to_time = ?2 limit 1", nativeQuery = true)
	Optional<TimePeriod> findByFromAndTo(LocalTime from, LocalTime to);
}
