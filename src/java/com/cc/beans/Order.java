/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cc.beans;

/**
 *
 * @author Louis
 */
public class Order {
    /* Propriétés du bean */
    private Customer customer;
    private String date;
    private Double amount;
    private String paymentMode;
    private String paymentState;
    private String deliveryMode;
    private String deliveryState;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer( Customer customer ) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount( Double amount ) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode( String paymentMode ) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState( String paymentState ) {
        this.paymentState = paymentState;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode( String deliveryMode ) {
        this.deliveryMode = deliveryMode;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState( String deliveryState ) {
        this.deliveryState = deliveryState;
    }
}