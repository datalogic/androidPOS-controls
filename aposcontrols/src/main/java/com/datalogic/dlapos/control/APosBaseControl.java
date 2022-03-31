package com.datalogic.dlapos.control;

import android.content.Context;

import com.datalogic.dlapos.commons.constant.CommonsConstants;
import com.datalogic.dlapos.commons.constant.ErrorConstants;
import com.datalogic.dlapos.commons.control.BaseControl;
import com.datalogic.dlapos.commons.event.EventCallback;
import com.datalogic.dlapos.commons.service.BaseService;
import com.datalogic.dlapos.commons.support.APosException;
import com.datalogic.dlapos.commons.upos.RequestListener;
import com.datalogic.dlapos.confighelper.DLAPosConfigHelper;
import com.datalogic.dlapos.confighelper.ServiceConnector;
import com.datalogic.dlapos.control.event.EventHandler;
import com.datalogic.dlapos.control.event.EventListener;
import com.datalogic.dlapos.control.support.ExceptionFactory;
import com.datalogic.dlapos.control.support.Invoker;

abstract class APosBaseControl implements BaseControl {
    protected int _controlVersion;
    protected String _controlDescription;
    protected int _serviceVersion;
    protected boolean _isOpen = false;
    protected BaseService _service;
    protected ServiceConnector _connector;
    protected EventHandler _eventHandler;

    //region Implementations

    //region Properties
    @Override
    public boolean getAutoDisable() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getAutoDisable, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setAutoDisable(boolean b) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::setAutoDisable, b, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getDataCount() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getDataCount, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getDataEventEnabled() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getDataEventEnabled, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setDataEventEnabled(boolean b) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::setDataEventEnabled, b, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getPowerNotify() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getPowerNotify, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setPowerNotify(int i) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::setPowerNotify, i, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getPowerState() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getPowerState, ExceptionFactory.createUncaughtException());
    }

    @Override
    public String getCheckHealthText() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getCheckHealthText, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getClaimed() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getClaimed, ExceptionFactory.createUncaughtException());
    }

    @Override
    public String getDeviceControlDescription() {
        return _controlDescription;
    }

    @Override
    public int getDeviceControlVersion() {
        return _controlVersion;
    }

    @Override
    public boolean getDeviceEnabled() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getDeviceEnabled, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setDeviceEnabled(Boolean enabled) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::setDeviceEnabled, enabled, ExceptionFactory.createUncaughtException());
    }

    @Override
    public String getDeviceServiceDescription() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getDeviceServiceDescription, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getDeviceServiceVersion() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getDeviceServiceVersion, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getFreezeEvents() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getFreezeEvents, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void setFreezeEvents(boolean value) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::setFreezeEvents, value, ExceptionFactory.createUncaughtException());
    }

    @Override
    public String getPhysicalDeviceDescription() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getPhysicalDeviceDescription, ExceptionFactory.createUncaughtException());
    }

    @Override
    public String getPhysicalDeviceName() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getPhysicalDeviceName, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getState() {
        try {
            checkOpen();
            return _service.getState();
        } catch (Exception e) {
            return CommonsConstants.S_CLOSED;
        }
    }


    //endregion

    //region Capabilities
    @Override
    public boolean getCapCompareFirmwareVersion() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getCapCompareFirmwareVersion, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapUpdateFirmware() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getCapUpdateFirmware, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapUpdateStatistics() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getCapUpdateStatistics, ExceptionFactory.createUncaughtException());
    }

    @Override
    public boolean getCapStatisticsReporting() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getCapStatisticsReporting, ExceptionFactory.createUncaughtException());
    }

    @Override
    public int getCapPowerReporting() throws APosException {
        checkOpen();
        return Invoker.safeCall(_service::getCapPowerReporting, ExceptionFactory.createUncaughtException());
    }
    //endregion

    //region Methods

    @Override
    public void claim(int timeout) throws APosException {
        checkOpen();
        Invoker.safeCall(() -> {
            _service.claim(timeout);
        }, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void claim(RequestListener listener) throws APosException {
        checkOpen();
        Invoker.safeCall(() -> {
            _service.claim(listener);
        }, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void close() throws APosException {
        //TODO: the finally clause must include the safe call
        checkOpen();
        Invoker.safeCall(_service::close, ExceptionFactory.createUncaughtException());
        try {
            _service.delete();
        } catch (Exception e) {
            throw new APosException("Unhandled Exception", ErrorConstants.APOS_E_FAILURE, e);
        } finally {
            _service = null;
            _serviceVersion = 0;
            _isOpen = false;
        }
    }

    @Override
    public void checkHealth(int level) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::checkHealth, level, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void directIO(int command, int[] data, Object object) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::directIO, command, data, object, ExceptionFactory.createUncaughtException());
    }

    @Override
    public synchronized void open(String s, Context context) throws APosException {
        if (_isOpen) {
            throw new APosException(s + " already open.", ErrorConstants.APOS_E_ILLEGAL);
        }
        if (!DLAPosConfigHelper.getInstance(context).isInitialized()) {
            DLAPosConfigHelper.getInstance(context).initialize(context);
        }
        _connector = Invoker.safeCall(DLAPosConfigHelper.getInstance(context)::getServiceConnectorForProfileId, s, new APosException("Can not find the desired profile.", ErrorConstants.APOS_E_NOEXISTS));
        Invoker.safeCall(_connector::connect, context, new APosException("Can not connect to the service.", ErrorConstants.APOS_E_NOSERVICE));
        try {
            setService((BaseService) _connector.getService());
        } catch (Exception e) {
            throw new APosException("Can not get the service instance.", e);
        }
        try {
            Invoker.safeCall(() -> {
                _service.open(s, _eventHandler, context);
                _serviceVersion = _service.getDeviceServiceVersion();
                _isOpen = true;
            }, ExceptionFactory.createUncaughtException());
        } catch (APosException e) {
            _service.close();
            _connector.disconnect();
            _connector = null;
            _service = null;
            throw e;
        }
    }

    @Override
    public void release() throws APosException {
        checkOpen();
        Invoker.safeCall(_service::release, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void clearInput() throws APosException {
        checkOpen();
        Invoker.safeCall(_service::clearInput, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void resetStatistics(String s) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::resetStatistics, s, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void retrieveStatistics(String[] strings) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::retrieveStatistics, strings, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void updateStatistics(String s) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::updateStatistics, s, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void compareFirmwareVersion(String s, int[] ints) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::compareFirmwareVersion, s, ints, ExceptionFactory.createUncaughtException());
    }

    @Override
    public void updateFirmware(String s) throws APosException {
        checkOpen();
        Invoker.safeCall(_service::updateFirmware, s, ExceptionFactory.createUncaughtException());
    }

    //endregion

    //endregion

    //region Events
    public void addEventListener(EventListener listener, EventCallback.EventType type) {
        _eventHandler.addListener(listener, type);
    }

    public void removeEventListener(EventListener listener, EventCallback.EventType type) {
        _eventHandler.removeListener(listener, type);
    }
    //endregion

    protected abstract void setService(BaseService service) throws APosException;

    //region Support functions
    protected void checkOpen() throws APosException {
        if (!_isOpen) {
            throw new APosException("Open the Control before using it.", ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion
}
