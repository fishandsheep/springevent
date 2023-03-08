package com.example.app.event;

import com.example.app.bean.OrderCase;
import org.springframework.context.ApplicationEvent;

public class OrderSuccessEvent extends ApplicationEvent {

    private OrderCase orderCase;

    public OrderSuccessEvent(OrderCase orderCase) {
        super(orderCase);
        this.orderCase = orderCase;
    }


    public OrderCase getOrder() {
        return orderCase;
    }
}
