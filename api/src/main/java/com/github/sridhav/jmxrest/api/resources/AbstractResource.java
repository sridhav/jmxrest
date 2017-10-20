package com.github.sridhav.jmxrest.api.resources;

import com.github.sridhav.jmxrest.api.dto.SuccessDto;

class AbstractResource {

    protected SuccessDto getSuccess() {
        SuccessDto successDto = new SuccessDto();
        successDto.setSuccess(true);
        return  successDto;
    }

    protected SuccessDto getFailure() {
        SuccessDto successDto = new SuccessDto();
        successDto.setSuccess(false);
        return  successDto;
    }

}
