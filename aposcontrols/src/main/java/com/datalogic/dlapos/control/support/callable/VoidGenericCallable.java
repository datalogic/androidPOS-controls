package com.datalogic.dlapos.control.support.callable;

@FunctionalInterface
public interface VoidGenericCallable {

    void callVarArgs(Object... args) throws Exception;

}
