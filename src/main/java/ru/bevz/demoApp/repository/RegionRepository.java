package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.Region;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

	Optional<Region> findByNumber(int number);
}
