package com.demo.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterCardOrderResponse {
    private String result;
    private Order order;
    private List<Transaction> transaction;

    @Data
    public static class Order {
        private String id;
        private String status;
        private String currency;
        private String amount;
    }

    @Data
    public static class Transaction {
        private String id;
        private String type;
        private String status;
        private SourceOfFunds sourceOfFunds;
        private Response response;

        @Data
        public static class SourceOfFunds {
            private Provided provided;

            @Data
            public static class Provided {
                private Card card;

                @Data
                public static class Card {
                    private String number;
                    private Expiry expiry;
                    private String scheme;

                    @Data
                    public static class Expiry {
                        private String month;
                        private String year;
                    }
                }
            }
        }

        @Data
        public static class Response {
            private String gatewayCode;
            private String acquirerCode;
        }
    }
}

