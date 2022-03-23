package com.datalogic.dlapos.control;

import android.content.Context;

import com.datalogic.dlapos.commons.constant.CommonsConstants;
import com.datalogic.dlapos.commons.constant.ErrorConstants;
import com.datalogic.dlapos.commons.service.BaseService;
import com.datalogic.dlapos.commons.support.APosException;
import com.datalogic.dlapos.confighelper.DLAPosConfigHelper;
import com.datalogic.dlapos.confighelper.ServiceConnector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Objects;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DLAPosConfigHelper.class)
public class APosBaseControlTest {

    @Mock
    private Context context;

    @Mock
    private final BaseService service = mock(BaseService.class);

    @Mock
    private final DLAPosConfigHelper _configHelper = mock(DLAPosConfigHelper.class);

    @Mock
    private final ServiceConnector _connector = mock(ServiceConnector.class);

    //region Properties
    @Test
    public void getAutoDisableClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getAutoDisable();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getAutoDisable() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getAutoDisable();
        verify(service, times(1)).getAutoDisable();
    }

    @Test
    public void setAutoDisableClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.setAutoDisable(true);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void setAutoDisable() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.setAutoDisable(true);
        verify(service, times(1)).setAutoDisable(true);
    }

    @Test
    public void getDataCount() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getDataCount();
        verify(service, times(1)).getDataCount();
    }

    @Test
    public void getDataCountClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getDataCount();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getDataEventEnabled() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getDataEventEnabled();
        verify(service, times(1)).getDataEventEnabled();
    }

    @Test
    public void getDataEventEnabledClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getDataEventEnabled();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void setDataEventEnabled() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.setDataEventEnabled(true);
        verify(service, times(1)).setDataEventEnabled(true);
    }

    @Test
    public void setDataEventEnabledClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.setDataEventEnabled(true);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getPowerNotify() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getPowerNotify();
        verify(service, times(1)).getPowerNotify();
    }

    @Test
    public void getPowerNotifyClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getPowerNotify();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void setPowerNotify() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.setPowerNotify(0);
        verify(service, times(1)).setPowerNotify(0);
    }

    @Test
    public void setPowerNotifyClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.setPowerNotify(0);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getPowerState() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getPowerState();
        verify(service, times(1)).getPowerState();
    }

    @Test
    public void getPowerStateClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getPowerNotify();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getCheckHealthText() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getCheckHealthText();
        verify(service, times(1)).getCheckHealthText();
    }

    @Test
    public void getCheckHealthTextClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getCheckHealthText();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getClaimed() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getClaimed();
        verify(service, times(1)).getClaimed();
    }

    @Test
    public void getClaimedClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getClaimed();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getDeviceControlDescription() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        assertThat(control.getDeviceControlDescription()).isEqualTo(control._controlDescription);
    }

    @Test
    public void getDeviceControlDescriptionClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        assertThat(control.getDeviceControlDescription()).isEqualTo(control._controlDescription);
    }

    @Test
    public void getDeviceControlVersion() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        assertThat(control.getDeviceControlVersion()).isEqualTo(control._controlVersion);
    }

    @Test
    public void getDeviceControlVersionClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        assertThat(control.getDeviceControlDescription()).isEqualTo(control._controlDescription);
    }

    @Test
    public void getDeviceEnabled() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getDeviceEnabled();
        verify(service, times(1)).getDeviceEnabled();
    }

    @Test
    public void getDeviceEnabledClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getDeviceEnabled();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void setDeviceEnabled() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.setDeviceEnabled(true);
        verify(service, times(1)).setDeviceEnabled(true);
    }

    @Test
    public void setDeviceEnabledClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.setDeviceEnabled(true);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getDeviceServiceDescription() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getDeviceServiceDescription();
        verify(service, times(1)).getDeviceServiceDescription();
    }

    @Test
    public void getDeviceServiceDescriptionClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getDeviceServiceDescription();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getDeviceServiceVersion() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getDeviceServiceVersion();
        verify(service, times(1)).getDeviceServiceVersion();
    }

    @Test
    public void getDeviceServiceVersionClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getDeviceServiceVersion();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getFreezeEvents() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getFreezeEvents();
        verify(service, times(1)).getFreezeEvents();
    }

    @Test
    public void getFreezeEventsClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getFreezeEvents();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void setFreezeEvents() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.setFreezeEvents(true);
        verify(service, times(1)).setFreezeEvents(true);
    }

    @Test
    public void setFreezeEventsClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.setFreezeEvents(true);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getPhysicalDeviceDescription() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getPhysicalDeviceDescription();
        verify(service, times(1)).getPhysicalDeviceDescription();
    }

    @Test
    public void getPhysicalDeviceDescriptionClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getPhysicalDeviceDescription();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getPhysicalDeviceName() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getPhysicalDeviceName();
        verify(service, times(1)).getPhysicalDeviceName();
    }

    @Test
    public void getPhysicalDeviceNameClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getPhysicalDeviceName();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getState() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getState();
        verify(service, times(1)).getState();
    }

    @Test
    public void getStateClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        assertThat(control.getState()).isEqualTo(CommonsConstants.S_CLOSED);
    }

    //endregion

    //region Capabilities

    @Test
    public void getCapCompareFirmwareVersion() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getCapCompareFirmwareVersion();
        verify(service, times(1)).getCapCompareFirmwareVersion();
    }

    @Test
    public void getCapCompareFirmwareVersionClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getCapCompareFirmwareVersion();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getCapUpdateFirmware() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getCapUpdateFirmware();
        verify(service, times(1)).getCapUpdateFirmware();
    }

    @Test
    public void getCapUpdateFirmwareClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getCapUpdateFirmware();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getCapUpdateStatistics() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getCapUpdateStatistics();
        verify(service, times(1)).getCapUpdateStatistics();
    }

    @Test
    public void getCapUpdateStatisticsClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getCapUpdateStatistics();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getCapStatisticsReporting() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getCapStatisticsReporting();
        verify(service, times(1)).getCapStatisticsReporting();
    }

    @Test
    public void getCapStatisticsReportingClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getCapStatisticsReporting();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    @Test
    public void getCapPowerReporting() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.getCapPowerReporting();
        verify(service, times(1)).getCapPowerReporting();
    }

    @Test
    public void getCapPowerReportingClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.getCapPowerReporting();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    //endregion

    //region Method

    //region Claim

    @Test
    public void claim() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.claim(1);
        verify(service, times(1)).claim(1);
    }

    @Test
    public void claimClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.claim(1);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region Close
    @Test
    public void close() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.close();
        verify(service, times(1)).close();
    }

    @Test
    public void closeServiceDeleteFail() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        doThrow(new RuntimeException("TEST")).when(service).delete();
        control.setService(service);
        try {
            control.close();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_FAILURE);
            assertThat(Objects.requireNonNull(e.getCause()).getMessage()).isEqualTo("TEST");
        }
    }

    @Test
    public void closeClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.close();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region CheckHealth
    @Test
    public void checkHealth() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.checkHealth(1);
        verify(service, times(1)).checkHealth(1);
    }

    @Test
    public void checkHealthClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.checkHealth(1);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region DirectIO
    @Test
    public void directIO() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.directIO(1, null, null);
        verify(service, times(1)).directIO(1, null, null);
    }

    @Test
    public void directIOClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.directIO(1, null, null);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region Open

    @Test
    public void open() throws APosException {
        Whitebox.setInternalState(DLAPosConfigHelper.class, "_instance", _configHelper);
        when(_configHelper.isInitialized()).thenReturn(true);
        when(_configHelper.getServiceConnectorForProfileId("Test")).thenReturn(_connector);
        when(_connector.getService()).thenReturn(service);
        when(service.getDeviceServiceVersion()).thenReturn(1);
        TestBaseControl control = new TestBaseControl();
        control.open("Test", context);
        assertThat(control._connector).isEqualTo(_connector);
        assertThat(control._service).isEqualTo(service);
        assertThat(control._isOpen).isTrue();
        assertThat(control._serviceVersion).isEqualTo(1);
        verify(service, times(1)).open("Test", control._eventHandler, context);
    }

    @Test
    public void openAlreadyOpened() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.setService(service);
            control.open("Test", context);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_ILLEGAL);
            assertThat(control._isOpen).isTrue();
        }
    }

    @Test
    public void openFailInitialization() throws APosException {
        Whitebox.setInternalState(DLAPosConfigHelper.class, "_instance", _configHelper);
        when(_configHelper.isInitialized()).thenReturn(false);
        doThrow(new APosException("Test", ErrorConstants.APOS_E_FAILURE)).when(_configHelper).initialize(context);
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.open("Test", context);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_FAILURE);
            assertThat(control._isOpen).isFalse();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void openFailToFindProfile() throws APosException {
        Whitebox.setInternalState(DLAPosConfigHelper.class, "_instance", _configHelper);
        when(_configHelper.isInitialized()).thenReturn(true);
        doThrow(new RuntimeException("Test")).when(_configHelper).getServiceConnectorForProfileId("Test");
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.open("Test", context);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_NOEXISTS);
            assertThat(control._isOpen).isFalse();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void openFailConnect() throws APosException {
        Whitebox.setInternalState(DLAPosConfigHelper.class, "_instance", _configHelper);
        when(_configHelper.isInitialized()).thenReturn(true);
        when(_configHelper.getServiceConnectorForProfileId("Test")).thenReturn(_connector);
        doThrow(new RuntimeException("Test")).when(_connector).connect(context);
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.open("Test", context);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_NOSERVICE);
            assertThat(control._isOpen).isFalse();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void openFailSetService() throws APosException {
        Whitebox.setInternalState(DLAPosConfigHelper.class, "_instance", _configHelper);
        when(_configHelper.isInitialized()).thenReturn(true);
        when(_configHelper.getServiceConnectorForProfileId("Test")).thenReturn(_connector);
        ThrowingExceptionTestBaseControl control = new ThrowingExceptionTestBaseControl();
        try {
            control.open("Test", context);
            fail();
        } catch (APosException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("FAIL");
            assertThat(e.getMessage()).isEqualTo("Can not get the service instance.");
            assertThat(control._isOpen).isFalse();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void openFailOpenService() throws APosException {
        Whitebox.setInternalState(DLAPosConfigHelper.class, "_instance", _configHelper);
        when(_configHelper.isInitialized()).thenReturn(true);
        when(_configHelper.getServiceConnectorForProfileId("Test")).thenReturn(_connector);
        when(_connector.getService()).thenReturn(service);
        when(service.getDeviceServiceVersion()).thenReturn(1);
        TestBaseControl control = new TestBaseControl();
        doThrow(new RuntimeException("FAIL")).when(service).open("Test", control._eventHandler, context);
        try {
            control.open("Test", context);
            fail();
        } catch (APosException e) {
            assertThat(control._connector).isNull();
            assertThat(control._service).isNull();
            assertThat(control._isOpen).isFalse();
            verify(service, times(1)).open("Test", control._eventHandler, context);
        } catch (Exception e) {
            fail();
        }
    }
    //endregion

    //region Release
    @Test
    public void release() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.release();
        verify(service, times(1)).release();
    }

    @Test
    public void releaseClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.release();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region ClearInput
    @Test
    public void clearInput() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.clearInput();
        verify(service, times(1)).clearInput();
    }

    @Test
    public void clearInputClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.clearInput();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    //endregion

    //region ResetStatistics
    @Test
    public void resetStatistics() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.resetStatistics("Test");
        verify(service, times(1)).resetStatistics("Test");
    }

    @Test
    public void resetStatisticsClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.resetStatistics("Test");
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }

    //endregion

    //region RetrieveStatistics
    @Test
    public void retrieveStatistics() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        String[] par = new String[1];
        control.retrieveStatistics(par);
        verify(service, times(1)).retrieveStatistics(par);
    }

    @Test
    public void retrieveStatisticsClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            String[] par = new String[1];
            control.retrieveStatistics(par);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region UpdateStatistics
    @Test
    public void updateStatistics() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.updateStatistics("Test");
        verify(service, times(1)).updateStatistics("Test");
    }

    @Test
    public void updateStatisticsClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.updateStatistics("Test");
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region CompareFirmwareVersion
    @Test
    public void compareFirmwareVersion() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        int[] par = new int[1];
        control.compareFirmwareVersion("Test", par);
        verify(service, times(1)).compareFirmwareVersion("Test", par);
    }

    @Test
    public void compareFirmwareVersionClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            int[] par = new int[1];
            control.compareFirmwareVersion("Test", par);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //region UpdateFirmware
    @Test
    public void updateFirmware() throws APosException {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        control.setService(service);
        control.updateFirmware("Test");
        verify(service, times(1)).updateFirmware("Test");
    }

    @Test
    public void updateFirmwareClosed() {
        SelfOpeningTestBaseControl control = new SelfOpeningTestBaseControl();
        try {
            control.updateFirmware("Test");
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        }
    }
    //endregion

    //endregion


}