package com.zloyegor.mispi.lab4.management;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TimeSpanQualifier implements TimeSpanQualifierMBean{

    private AtomicLong initTime = new AtomicLong(new Date().getTime() / 1000);
    private AtomicLong lastClickTime = new AtomicLong(initTime.get());
    private AtomicInteger dotAmount = new AtomicInteger(0);

    private static TimeSpanQualifier timeSpanQualifier = new TimeSpanQualifier();

    public static TimeSpanQualifier getInstance() {
        return timeSpanQualifier;
    }

    @Override
    public void process() {
        lastClickTime.set(new Date().getTime() / 1000);
        dotAmount.getAndIncrement();
    }

    @Override
    public long getTimeSpan() {
        if (dotAmount.get() > 0)
            return (lastClickTime.get() - initTime.get()) / dotAmount.get();
        else
            return 0;
    }
}
