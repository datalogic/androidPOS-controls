package com.datalogic.dlapos.control.support;

import com.datalogic.dlapos.commons.support.APosException;
import com.datalogic.dlapos.control.support.callable.CallableOneParam;
import com.datalogic.dlapos.control.support.callable.VoidCallable;
import com.datalogic.dlapos.control.support.callable.VoidCallableFourParams;
import com.datalogic.dlapos.control.support.callable.VoidCallableOneParam;
import com.datalogic.dlapos.control.support.callable.VoidCallableThreeParams;
import com.datalogic.dlapos.control.support.callable.VoidCallableTwoParams;

import java.util.concurrent.Callable;

public class Invoker {

    public static <T> T safeCall(Callable<T> method, APosException exceptionToThrow) throws APosException {
        try {
            return method.call();
        } catch (APosException e) {
            throw e;
        } catch (Exception e) {
            exceptionToThrow.initCause(e);
            throw exceptionToThrow;
        }
    }

    public static <T> void safeCall(VoidCallableOneParam<T> method, T param, APosException exceptionToThrow) throws APosException {
        try {
            method.call(param);
        } catch (APosException e) {
            throw e;
        } catch (Exception e) {
            exceptionToThrow.initCause(e);
            throw exceptionToThrow;
        }
    }

    public static <T, S> void safeCall(VoidCallableTwoParams<T, S> method, T firstParam, S secondParam, APosException exceptionToThrow) throws APosException {
        try {
            method.call(firstParam, secondParam);
        } catch (APosException e) {
            throw e;
        } catch (Exception e) {
            exceptionToThrow.initCause(e);
            throw exceptionToThrow;
        }
    }

    public static <T, S, V> void safeCall(VoidCallableThreeParams<T, S, V> method, T firstParam, S secondParam, V thirdParam, APosException exceptionToThrow) throws APosException {
        try {
            method.call(firstParam, secondParam, thirdParam);
        } catch (APosException e) {
            throw e;
        } catch (Exception e) {
            exceptionToThrow.initCause(e);
            throw exceptionToThrow;
        }
    }

    public static <T, S, V, Z> void safeCall(VoidCallableFourParams<T, S, V, Z> method, T firstParam, S secondParam, V thirdParam, Z fourthParameter, APosException exceptionToThrow) throws APosException {
        try {
            method.call(firstParam, secondParam, thirdParam, fourthParameter);
        } catch (APosException e) {
            throw e;
        } catch (Exception e) {
            exceptionToThrow.initCause(e);
            throw exceptionToThrow;
        }
    }

    public static void safeCall(VoidCallable method, APosException exceptionToThrow) throws APosException {
        try {
            method.call();
        } catch (APosException e) {
            throw e;
        } catch (Exception e) {
            exceptionToThrow.initCause(e);
            throw exceptionToThrow;
        }
    }

    public static <T, R> R safeCall(CallableOneParam<T, R> method, T param, APosException exceptionToThrow) throws APosException {
        try {
            return method.call(param);
        } catch (APosException e) {
            throw e;
        } catch (Exception e) {
            exceptionToThrow.initCause(e);
            throw exceptionToThrow;
        }
    }


}
