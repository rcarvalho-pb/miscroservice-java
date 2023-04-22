package com.mscourse.hrpayroll.services;

import com.mscourse.hrpayroll.entities.Payment;
import com.mscourse.hrpayroll.entities.Worker;
import com.mscourse.hrpayroll.workerfeign.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;
    private final WorkerFeignClient client;
    public Payment getPayment(long workerId, int days){
        Worker worker = client.findById(workerId).getBody().get();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
