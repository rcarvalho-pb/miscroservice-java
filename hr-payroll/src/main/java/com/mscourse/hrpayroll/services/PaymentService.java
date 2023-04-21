package com.mscourse.hrpayroll.services;

import com.mscourse.hrpayroll.entities.Payment;
import com.mscourse.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;
    private final RestTemplate restTemplate;
    public Payment getPayment(long workerId, int days){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + workerId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);


        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
