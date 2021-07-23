package com.awesome_calculator.models.factorial_api;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class GetFactorial {
  private final String number;
}
