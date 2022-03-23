package com.datalogic.dlapos.control.support.callable;

@FunctionalInterface
public interface CallableOneParam<T, R> {
    R call(T param) throws Exception;
}
