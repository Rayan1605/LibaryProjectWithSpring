package com.project1.libaryproject.RequestModels;

import lombok.Data;

@Data
public class PaymentInfoRequest {
    private int amount;
    private String userEmail;
    private String  receiptEmail;
}
