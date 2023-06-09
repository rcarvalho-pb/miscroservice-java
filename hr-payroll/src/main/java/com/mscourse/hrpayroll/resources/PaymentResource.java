package com.mscourse.hrpayroll.resources;

import com.mscourse.hrpayroll.entities.Payment;
import com.mscourse.hrpayroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentResource {
    private final PaymentService service;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable Integer days) throws InterruptedException {

        Thread.sleep(3000);

        return ResponseEntity.ok(service.getPayment(workerId, days));
    }

}
