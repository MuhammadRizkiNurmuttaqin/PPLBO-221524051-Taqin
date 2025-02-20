package com.techie.microservices.order.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
// import static com.github.tomakehurst.wiremock.client.Wiremock.aResponse;

public class InventoryClientStub {

    public static void stubInventoryCall(String skuCode, int quantity) {
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("true")));
    }
}
