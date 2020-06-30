package com.hatanaka.ecommerce.checkout.resource.checkout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String complement;
    private String country;
    private String state;
    private String cep;
    private Boolean saveAddress;
    private Boolean saveInfo;
    private String paymentMethod;
    private String cardName;
    private String cardNumber;
    private String cardDate;
    private String cardCvv;
    private List<String> products;
}

