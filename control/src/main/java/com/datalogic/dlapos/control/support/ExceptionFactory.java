package com.datalogic.dlapos.control.support;

import com.datalogic.dlapos.commons.constant.ErrorConstants;
import com.datalogic.dlapos.commons.support.APosException;

public class ExceptionFactory {
    public static APosException createUncaughtException(){
        return  new APosException("Unhandled Exception", ErrorConstants.APOS_E_FAILURE);
    }
}
