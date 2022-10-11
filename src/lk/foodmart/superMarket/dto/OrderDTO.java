

package lk.foodmart.superMarket.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderDTO {
    private String orderId;
    private LocalDate orderDate;
    private String cusId;
    List<OrderDetailDTO> orderDetails;

    private String customerName;
    private BigDecimal orderTotal;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, LocalDate orderDate, String cusId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.cusId = cusId;
    }

    public OrderDTO(String orderId, LocalDate orderDate, String cusId, List<OrderDetailDTO> orderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.cusId = cusId;
        this.orderDetails = orderDetails;
    }

    public OrderDTO(String orderId, LocalDate orderDate, String cusId, List<OrderDetailDTO> orderDetails, String customerName, BigDecimal orderTotal) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.cusId = cusId;
        this.orderDetails = orderDetails;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", cusId='" + cusId + '\'' +
                ", orderDetails=" + orderDetails +
                ", customerName='" + customerName + '\'' +
                ", orderTotal=" + orderTotal +
                '}';
    }
}
