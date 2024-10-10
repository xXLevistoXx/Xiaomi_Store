package com.web_project.school.service;

import com.web_project.school.model.OrderItemModel;

import java.util.List;
import java.util.UUID;

public interface OrderItemService {
    public List<OrderItemModel> findAllOrderItems();

    public OrderItemModel findOrderItemById(UUID id);

    public OrderItemModel addOrderItem(OrderItemModel orderItem);

    public OrderItemModel updateOrderItem(OrderItemModel orderItem);

    public void deleteOrderItem(UUID id);
}