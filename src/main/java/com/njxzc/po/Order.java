package com.njxzc.po;

public class Order {
    private Integer id;
    private Integer busertable_id;
    private Double amount;
    private String status;
    private String orderdata;

    private Integer orderbasetable_id;
    private Integer goodstable_id;
    private Integer shoppingnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusertable_id() {
        return busertable_id;
    }

    public void setBusertable_id(Integer busertable_id) {
        this.busertable_id = busertable_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderdata() {
        return orderdata;
    }

    public void setOrderdata(String orderdata) {
        this.orderdata = orderdata;
    }

    public Integer getOrderbasetable_id() {
        return orderbasetable_id;
    }

    public void setOrderbasetable_id(Integer orderbasetable_id) {
        this.orderbasetable_id = orderbasetable_id;
    }

    public Integer getGoodstable_id() {
        return goodstable_id;
    }

    public void setGoodstable_id(Integer goodstable_id) {
        this.goodstable_id = goodstable_id;
    }

    public Integer getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(Integer shoppingnum) {
        this.shoppingnum = shoppingnum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", busertable_id=" + busertable_id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", orderdata='" + orderdata + '\'' +
                ", orderbasetable_id=" + orderbasetable_id +
                ", goodstable_id=" + goodstable_id +
                ", shoppingnum=" + shoppingnum +
                '}';
    }
}
