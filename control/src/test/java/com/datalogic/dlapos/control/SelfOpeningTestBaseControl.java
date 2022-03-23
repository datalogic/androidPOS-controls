package com.datalogic.dlapos.control;

import com.datalogic.dlapos.commons.service.BaseService;
import com.datalogic.dlapos.commons.support.APosException;

public class SelfOpeningTestBaseControl extends APosBaseControl {

    public SelfOpeningTestBaseControl() {
        _controlDescription = "TEST_CONTROL";
        _controlVersion = 1;
    }

    @Override
    protected void setService(BaseService service) throws APosException {
        _service = service;
        _isOpen = true;
    }
}
