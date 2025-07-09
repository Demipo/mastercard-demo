package com.demo.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterCardController {

    @GetMapping("/payment/verify")
    public ResponseEntity<String> verifyPayment(
        @RequestParam String result,
        @RequestParam String checkoutSessionId,
        @RequestParam String orderId
    ) {
        try {
            System.out.println("Result~~~CheckoutSessionId~~~OrderId: " + result + "~~~" + checkoutSessionId + "~~~" +  orderId);
            return ResponseEntity.ok(result + "~~~" + checkoutSessionId + "~~~" +  orderId);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error verifying payment: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error verifying payment: " + ex.getMessage());
        }
    }
}
