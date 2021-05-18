package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.TotalRegionIndicatorsCourier;

@Repository
public interface TotalRegionIndicatorsCourierRepository extends JpaRepository<TotalRegionIndicatorsCourier, Long> {
}
