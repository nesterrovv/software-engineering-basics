package com.zloyegor.mispi.lab4.management;

import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationFilterSupport;
import javax.management.NotificationListener;

public class MBeanListener implements NotificationListener {

    private final String notificationType;

    public MBeanListener(String notificationType) {
        this.notificationType = notificationType;
    }

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println(String.format("Listener %s: %s", notificationType, notification.getMessage()));
    }

    public NotificationFilter getNotificationFilter() {
        NotificationFilterSupport filter = new NotificationFilterSupport();
        filter.enableType(notificationType);
        return filter;
    }
}
