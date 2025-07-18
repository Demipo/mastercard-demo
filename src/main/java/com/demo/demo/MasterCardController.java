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
        @RequestParam(required = false) String resultIndicator,
        @RequestParam(required = false) String sessionVersion,
        @RequestParam(required = false) String checkoutVersion
    ) {
        try {
            System.out.println("ResultIndicator~~~SessionVersion~~~CheckoutVersion: " + resultIndicator + "~~~" + sessionVersion + "~~~" +  checkoutVersion);
            return ResponseEntity.ok(resultIndicator + "~~~" + sessionVersion + "~~~" +  checkoutVersion);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error verifying payment: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error verifying payment: " + ex.getMessage());
        }
    }
}
