package com.web_project.school.service;

import com.web_project.school.model.OrderItemModel;
import com.web_project.school.repository.OrderItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryOrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public InMemoryOrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItemModel> findAllOrderItems() {
        return orderItemRepository.findAll(Sort.by("id"));
    }

    @Override
    public OrderItemModel findOrderItemById(UUID id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItemModel addOrderItem(OrderItemModel orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItemModel updateOrderItem(OrderItemModel orderItem) {
        if (orderItemRepository.existsById(orderItem.getId())) {
            return orderItemRepository.save(orderItem);
        }
        return null;
    }

    @Override
    public void deleteOrderItem(UUID id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
        }
    }
}