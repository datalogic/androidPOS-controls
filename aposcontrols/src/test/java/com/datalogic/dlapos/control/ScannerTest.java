package com.datalogic.dlapos.control;

import com.datalogic.dlapos.commons.constant.ErrorConstants;
import com.datalogic.dlapos.commons.service.BaseService;
import com.datalogic.dlapos.commons.service.ScannerBaseService;
import com.datalogic.dlapos.commons.support.APosException;

import org.junit.Test;
import org.mockito.Mock;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ScannerTest {

    @Mock
    private final BaseService _baseService = mock(BaseService.class);

    @Mock
    private final ScannerBaseService _scannerService = mock(ScannerBaseService.class);

    //region Properties
    @Test
    public void getDecodeData() throws APosException {
        Scanner testScanner = new Scanner();
        testScanner._service = _scannerService;
        testScanner._isOpen = true;
        testScanner.getDecodeData();
        verify(_scannerService, times(1)).getDecodeData();
    }

    @Test
    public void getDecodeDataClosed() {
        Scanner testScanner = new Scanner();
        try {
            testScanner.getDecodeData();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void setDecodeData() throws APosException {
        Scanner testScanner = new Scanner();
        testScanner._service = _scannerService;
        testScanner._isOpen = true;
        testScanner.setDecodeData(true);
        verify(_scannerService, times(1)).setDecodeData(true);
    }

    @Test
    public void setDecodeDataClosed() {
        Scanner testScanner = new Scanner();
        try {
            testScanner.setDecodeData(true);
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getScanData() throws APosException {
        Scanner testScanner = new Scanner();
        testScanner._service = _scannerService;
        testScanner._isOpen = true;
        testScanner.getScanData();
        verify(_scannerService, times(1)).getScanData();
    }

    @Test
    public void getScanDataClosed() {
        Scanner testScanner = new Scanner();
        try {
            testScanner.getScanData();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getScanDataLabel() throws APosException {
        Scanner testScanner = new Scanner();
        testScanner._service = _scannerService;
        testScanner._isOpen = true;
        testScanner.getScanDataLabel();
        verify(_scannerService, times(1)).getScanDataLabel();
    }

    @Test
    public void getScanDataLabelClosed() {
        Scanner testScanner = new Scanner();
        try {
            testScanner.getScanDataLabel();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getScanDataType() throws APosException {
        Scanner testScanner = new Scanner();
        testScanner._service = _scannerService;
        testScanner._isOpen = true;
        testScanner.getScanDataType();
        verify(_scannerService, times(1)).getScanDataType();
    }

    @Test
    public void getScanDataTypeClosed() {
        Scanner testScanner = new Scanner();
        try {
            testScanner.getScanDataType();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        } catch (Exception e) {
            fail();
        }
    }

    //endregion

    //region Methods
    //region ClearInputProperties
    @Test
    public void clearInputProperties() throws APosException {
        Scanner testScanner = new Scanner();
        testScanner._service = _scannerService;
        testScanner._isOpen = true;
        testScanner.clearInputProperties();
        verify(_scannerService, times(1)).clearInputProperties();
    }

    @Test
    public void clearInputPropertiesClosed() {
        Scanner testScanner = new Scanner();
        try {
            testScanner.clearInputProperties();
            fail();
        } catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_CLOSED);
        } catch (Exception e) {
            fail();
        }
    }
    //endregion

    //region SetService
    @Test
    public void setService() throws APosException {
        Scanner testScanner = new Scanner();
        testScanner.setService(_scannerService);
        assertThat(testScanner._service).isEqualTo(_scannerService);
    }

    @Test
    public void setWrongService() {
        Scanner testScanner = new Scanner();
        try {
            testScanner.setService(_baseService);
            fail();
        }catch (APosException e) {
            assertThat(e.getErrorCode()).isEqualTo(ErrorConstants.APOS_E_NOSERVICE);
        } catch (Exception e) {
            fail();
        }
    }

    //endregion
    //endregion

}