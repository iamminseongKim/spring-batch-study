package io.springbatch.service;

import io.springbatch.batch.domain.ApiRequestVO;
import io.springbatch.batch.domain.ApiResponseVO;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.List;

public abstract class AbstractApiService {

    public ApiResponseVO service(List<? extends ApiRequestVO> apiRequest) {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

        restTemplateBuilder.errorHandler( {
    }
}
