package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
}
