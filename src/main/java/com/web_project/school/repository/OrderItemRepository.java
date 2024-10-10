package com.web_project.school.repository;

import com.web_project.school.model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, UUID> {
}