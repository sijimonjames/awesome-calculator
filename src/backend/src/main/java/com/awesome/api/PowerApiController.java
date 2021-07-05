package com.awesome.api;

import com.awesome.swagger.ApiResponseData;
import com.awesome.swagger.ModelApiResponse;
import com.awesome.swagger.PowerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * Controller for {@link PowerApi}.
 */
@Controller
public class PowerApiController implements PowerApi {

  private Integer calculatePower(Integer number, Integer power)
  {
    if (power == 0){
      return 1;
    }else{
      return number*calculatePower(number,power-1);
    }
  }

  @Override
  public ResponseEntity<ModelApiResponse> power(Integer number, Integer power) {

    ModelApiResponse response = new ModelApiResponse().data(new ApiResponseData().number(calculatePower(number, power)));

    return ResponseEntity.ok(response);
  }
}
