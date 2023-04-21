package com.mscourse.hrpayroll.servicies;

import com.mscourse.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        return new Payment("bob", 200.00, 10);
    }
}
