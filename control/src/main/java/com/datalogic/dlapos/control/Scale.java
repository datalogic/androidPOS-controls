package com.datalogic.dlapos.control;

import com.datalogic.dlapos.commons.constant.ErrorConstants;
import com.datalogic.dlapos.commons.control.ScaleBaseControl;
import com.datalogic.dlapos.commons.service.BaseService;
import com.datalogic.dlapos.commons.service.ScaleBaseService;
import com.datalogic.dlapos.commons.support.APosException;
import com.datalogic.dlapos.control.event.EventHandler;
import com.datalogic.dlapos.control.support.ExceptionFactory;
import com.datalogic.dlapos.control.support.Invoker;

public class Scale extends APosBaseControl implements ScaleBaseControl {

    public Scale() {
        _eventHandler = new EventHandler(this);
    }

    @Override
    protected void setService(BaseService service) throws APosException {
        try {
            _service = (ScaleBaseService) service;
        } catch (Exception e) {
            throw new APosException("Service is not a ScaleService.", ErrorConstants.APOS_E_NOSERVICE);
        }
    }

    //region Capabilities

    @Override
    public boolean getCapDisplay() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapDisplay, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapDisplayText() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapDisplayText, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapFreezeValue() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapFreezeValue, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapPriceCalculating() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapPriceCalculating, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapReadLiveWeightWithTare() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapReadLiveWeightWithTare, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapSetPriceCalculationMode() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapSetPriceCalculationMode, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapSetUnitPriceWithWeightUnit() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapSetUnitPriceWithWeightUnit, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapSpecialTare() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapSpecialTare, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapStatusUpdate() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapStatusUpdate, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapTarePriority() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapTarePriority, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapTareWeight() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapTareWeight, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapZeroScale() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getCapZeroScale, ExceptionFactory.createUncaughtException());
    }

    //endregion

    //region Properties
    @Override
    public boolean getAsyncMode() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getAsyncMode, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setAsyncMode(boolean b) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setAsyncMode, b, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getMaxDisplayTextChars() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getMaxDisplayTextChars, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getMaximumWeight() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getMaximumWeight, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getMinimumWeight() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getMinimumWeight, ExceptionFactory.createUncaughtException());
    }

    @Override
    public long getSalesPrice() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getSalesPrice, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getScaleLiveWeight() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getScaleLiveWeight, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getStatusNotify() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getStatusNotify, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getTareWeight() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getTareWeight, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setTareWeight(int i) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setTarePriority, i, ExceptionFactory.createUncaughtException());
    }

    @Override
    public long getUnitPrice() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getUnitPrice, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setUnitPrice(long l) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setUnitPrice, l, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getWeightUnit() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getWeightUnit, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getZeroValid() throws APosException {
        checkOpen();
        return Invoker.safeCall(((ScaleBaseService) _service)::getZeroValid, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setZeroValid(boolean b) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setZeroValid, b, ExceptionFactory.createUncaughtException());
    }

    //endregion

    //region Methods

    @Override
    public void displayText(String data) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::displayText, data, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void doPriceCalculating(int[] weightValue, int[] tare, long[] unitPrice, long[] unitPriceX, int[] weightUnitX, int[] weightNumeratorX, int[] weightDenominatorX, long[] price, int timeout) throws APosException {
        checkOpen();
    }

    @Override
    public void freezeValue(int item, boolean freeze) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::freezeValue, item, freeze, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void readLiveWeightWithTare(int[] weightData, int[] tare, int timeout) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::readLiveWeightWithTare, weightData, tare, timeout, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void readWeight(int[] weightData, int timeout) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::readWeight, weightData, timeout, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setPriceCalculationMode(int mode) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setPriceCalculationMode, mode, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setSpecialTare(int mode, int data) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setSpecialTare, mode, data, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setTarePriority(int priority) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setTarePriority, priority, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setUnitPriceWithWeightUnit(long unitPrice, int weightUnit, int weightNumerator, int weightDenominator) throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::setUnitPriceWithWeightUnit, unitPrice, weightUnit, weightNumerator, weightDenominator, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void zeroScale() throws APosException {
        checkOpen();
        Invoker.safeCall(((ScaleBaseService) _service)::zeroScale, ExceptionFactory.createUncaughtException());
    }

    //endregion
}
