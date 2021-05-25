package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.RatingCourier;

@Repository
public interface RatingCourierRepository extends JpaRepository<RatingCourier, Long> {

}
