package com.example.app.controller;

import com.example.app.bean.OrderCase;
import com.example.app.event.OrderSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @GetMapping("/{type}")
    public Mono<OrderCase> orderByType(@PathVariable Integer type) {
        OrderCase orderCase = null;
        if (type == 1) {
            orderCase = OrderCase.builder()
                    .type(type)
                    .name("RTX4090ti")
                    .build();
        } else if (type == 2) {
            orderCase = OrderCase.builder()
                    .type(type)
                    .name("iphone14 pro")
                    .build();

        }

        List<String> traces = new ArrayList<>();
        traces.add("order over.");
        orderCase.setTraces(traces);

        //推送事件
        publisher.publishEvent(new OrderSuccessEvent(orderCase));

        return Mono.just(orderCase);
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
