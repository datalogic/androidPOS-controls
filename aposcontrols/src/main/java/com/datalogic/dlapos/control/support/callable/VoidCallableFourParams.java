package com.datalogic.dlapos.control.support.callable;

@FunctionalInterface
public interface VoidCallableFourParams<T, S, V, Z> {
    void call(T firstParam, S secondParam, V thirdParam, Z fourthParameter) throws Exception;
}
