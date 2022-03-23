package com.datalogic.dlapos.control.support.callable;

@FunctionalInterface
public interface VoidCallableOneParam<T> {

    void call(T data) throws Exception;

}

