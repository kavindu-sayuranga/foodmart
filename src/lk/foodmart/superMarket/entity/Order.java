

package lk.foodmart.superMarket.entity;

import java.time.LocalDate;

public class Order {
    private String orderId;
    private LocalDate orderDate;
    private String cusId;

    public Order() {
    }

    public Order(String orderId, LocalDate orderDate, String cusId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.cusId = cusId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
