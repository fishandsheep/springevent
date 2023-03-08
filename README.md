### spring-event

测试
```shell
curl -s http://localhost:8080/order/1
```
```json
  {
    "type": 1,
    "name": "RTX4090ti",
    "traces": [
      "order over.",
      "SmsListener over."
    ]
  }
```
---

```shell
curl -s http://localhost:8080/order/2
```
```json
{
  "type": 2,
  "name": "iphone14 pro",
  "traces": [
    "order over.",
    "Second CountSalesListener onListenOrder over.",
    "SmsListener over.",
    "First CountSalesListener onListenOrder over."
  ]
}

```