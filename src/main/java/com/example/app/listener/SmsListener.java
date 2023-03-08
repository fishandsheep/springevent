package com.example.app.listener;

import com.example.app.bean.OrderCase;
import com.example.app.event.OrderSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SmsListener implements ApplicationListener<OrderSuccessEvent> {

    @Override
    public void onApplicationEvent(OrderSuccessEvent event) {
        OrderCase orderCase = event.getOrder();
        orderCase.append("SmsListener over.");
    }
}
