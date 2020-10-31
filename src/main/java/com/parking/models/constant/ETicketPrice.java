package com.parking.models.constant;

import lombok.Getter;

/**
 * Author: Thien
 */
@Getter
public enum ETicketPrice {
  VIP_HOUR(5000.0),
  VIP_DAY(35000.0),
  VIP_WEEK(840000.0),
  VIP_MONTH(360000.0),

  NORMAL_HOUR(2000.0),
  NORMAL_DAY(48000.0),
  NORMAL_WEEK(336000.0),
  NORMAL_MONTH(1440000.0);

    private double price;

    ETicketPrice(double price) {
        this.price = price;
    }
}
