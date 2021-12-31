package com.backinfile.support.event;

import com.backinfile.support.Param;
import com.backinfile.support.func.Action1;
import com.backinfile.support.func.Function1;

@SuppressWarnings("unchecked")
public class ParamEventHandler extends AbstractEventHandler<Param> {
    @Override
    protected boolean handleEvent(Object observer, Param param) {
        if (observer instanceof Action1) {
            ((Action1<Param>) observer).invoke(param);
        } else if (observer instanceof Function1) {
            return ((Function1<Boolean, Param>) observer).invoke(param);
        }
        return false;
    }
}
