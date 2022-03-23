package com.datalogic.dlapos.control;

import com.datalogic.dlapos.commons.service.BaseService;
import com.datalogic.dlapos.commons.support.APosException;

public class ThrowingExceptionTestBaseControl extends APosBaseControl {

    public ThrowingExceptionTestBaseControl() {
        _controlDescription = "TEST_CONTROL";
        _controlVersion = 1;
    }

    @Override
    protected void setService(BaseService service) throws APosException {
        throw new APosException("FAIL");
    }
}
