package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.TypeCourier;

import java.util.Optional;

@Repository
public interface TypeCourierRepository extends JpaRepository<TypeCourier, Long> {

	Optional<TypeCourier> findByName(String name);
}
