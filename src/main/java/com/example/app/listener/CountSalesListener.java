package com.example.app.listener;


import com.example.app.bean.OrderCase;
import com.example.app.event.OrderSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CountSalesListener {


    @Async
    @Order(2)
    @EventListener(value = OrderSuccessEvent.class, condition = "#event.order.name.equals(\"iphone14 pro\")")
    public void onListenOrder1(OrderSuccessEvent event) {
        OrderCase orderCase = event.getOrder();
        orderCase.append("First CountSalesListener onListenOrder over.");
    }

    @Async
    @Order(1)
    @EventListener(condition = "#event.order.type == 2 ")
    public void onListenOrder2(OrderSuccessEvent event) throws InterruptedException {
        OrderCase orderCase = event.getOrder();
        orderCase.append("Second CountSalesListener onListenOrder over.");
        Thread.sleep(1000);
        System.out.println("onListenOrder2 over.");
    }


}
