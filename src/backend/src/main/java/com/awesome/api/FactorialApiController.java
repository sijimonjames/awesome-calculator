package com.awesome.api;

import com.awesome.swagger.ApiRequest;
import com.awesome.swagger.ApiResponseData;
import com.awesome.swagger.FactorialApi;
import com.awesome.swagger.ModelApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Controller for {@link FactorialApi}.
 */
@Controller
@CrossOrigin(origins = "http://localhost:8080")

public class FactorialApiController implements FactorialApi {

  private Integer calculateFactorial(Integer number){
    if(number == 0){
      return 1;
    }else{
      return number*calculateFactorial(number-1);
    }
  }

  @Override
  public ResponseEntity<ModelApiResponse> factorial(ApiRequest body) {

    ModelApiResponse response = new ModelApiResponse().data(new ApiResponseData().number(calculateFactorial(body.getNumber())));

    return ResponseEntity.ok(response);
  }
}
