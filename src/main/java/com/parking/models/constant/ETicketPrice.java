package com.parking.models.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Thien
 */
@Getter
public enum ETicketPrice {
  VIP_DAY(5000.0),
  VIP_WEEK(5000.0 * 7),
  VIP_MONTH(5000.0 * 30),

  NORMAL_DAY(2000.0),
  NORMAL_WEEK(2000.0 * 7),
  NORMAL_MONTH(2000.0 * 30);

    private double price;

    ETicketPrice(double price) {
        this.price = price;
    }
}
