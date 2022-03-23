package com.datalogic.dlapos.control;

import com.datalogic.dlapos.commons.constant.ErrorConstants;
import com.datalogic.dlapos.commons.control.ScannerBaseControl;
import com.datalogic.dlapos.commons.service.BaseService;
import com.datalogic.dlapos.commons.service.ScannerBaseService;
import com.datalogic.dlapos.commons.support.APosException;
import com.datalogic.dlapos.control.event.EventHandler;
import com.datalogic.dlapos.control.support.ExceptionFactory;
import com.datalogic.dlapos.control.support.Invoker;

public class Scanner extends APosBaseControl implements ScannerBaseControl {


    public Scanner() {
        _eventHandler = new EventHandler(this);
    }


    //region Properties
    @Override
    public boolean getDecodeData() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScannerBaseService) _service)::getDecodeData, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setDecodeData(boolean b) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScannerBaseService) _service)::setDecodeData, b, ExceptionFactory.createUncaughtException());
    }

    @Override
    public byte[] getScanData() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScannerBaseService) _service)::getScanData, ExceptionFactory.createUncaughtException());
    }

    @Override
    public byte[] getScanDataLabel() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScannerBaseService) _service)::getScanDataLabel, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getScanDataType() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScannerBaseService) _service)::getScanDataType, ExceptionFactory.createUncaughtException());
    }
    //endregion

    //region Methods
    @Override
    public void clearInputProperties() throws APosException {
        checkOpen();
        Invoker.safeCall(((ScannerBaseService) _service)::clearInputProperties, ExceptionFactory.createUncaughtException());
    }
    //endregion

    @Override
    protected void setService(BaseService service) throws APosException {
        try {
            _service = (ScannerBaseService) service;
        } catch (Exception e) {
            throw new APosException("Service is not a ScannerService.", ErrorConstants.APOS_E_NOSERVICE);
        }
    }
}