package com.datalogic.dlapos.control.support.callable;

@FunctionalInterface
public interface VoidCallableTwoParams<T, S> {

    void call(T firstParam, S secondParam) throws Exception;

}
