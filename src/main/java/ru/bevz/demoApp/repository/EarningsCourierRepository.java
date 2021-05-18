package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.EarningsCourier;

@Repository
public interface EarningsCourierRepository extends JpaRepository<EarningsCourier, Long> {
}
