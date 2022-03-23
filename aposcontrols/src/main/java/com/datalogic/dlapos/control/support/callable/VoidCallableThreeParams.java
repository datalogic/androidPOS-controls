package com.datalogic.dlapos.control.support.callable;

@FunctionalInterface
public interface VoidCallableThreeParams<T, S, V> {
    void call(T firstParam, S secondParam, V thirdParam) throws Exception;
}
