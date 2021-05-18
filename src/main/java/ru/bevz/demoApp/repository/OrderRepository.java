package ru.bevz.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bevz.demoApp.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
