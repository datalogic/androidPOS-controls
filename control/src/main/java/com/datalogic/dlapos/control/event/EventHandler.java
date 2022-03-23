package com.datalogic.dlapos.control.event;

import com.datalogic.dlapos.commons.control.BaseControl;
import com.datalogic.dlapos.commons.event.BaseEvent;
import com.datalogic.dlapos.commons.event.EventCallback;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventHandler implements EventCallback {

    private final Map<EventType, Set<EventListener>> _listeners;
    private final BaseControl _source;

    public EventHandler(BaseControl source) {
        _source = source;
        _listeners = new HashMap<>();
        for (EventType e : EventType.values()) {
            _listeners.put(e, new HashSet<>());
        }
    }

    public void addListener(EventListener listener, EventType type) {
        synchronized (_listeners.get(type)) {
            _listeners.get(type).add(listener);
        }
    }

    public void removeListener(EventListener listener, EventType type) {
        synchronized (_listeners.get(type)) {
            _listeners.get(type).remove(listener);
        }
    }

    @Override
    public void fireEvent(BaseEvent baseEvent, EventType eventType) {
        synchronized (_listeners.get(eventType)) {
            for (EventListener listener : _listeners.get(eventType)) {
                listener.onEvent(baseEvent);
            }
        }
    }

    @Override
    public BaseControl getEventSource() {
        return _source;
    }
}
