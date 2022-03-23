package com.datalogic.dlapos.control.event;

import com.datalogic.dlapos.commons.event.BaseEvent;

@FunctionalInterface
public interface EventListener {
    void onEvent(BaseEvent event);
}
