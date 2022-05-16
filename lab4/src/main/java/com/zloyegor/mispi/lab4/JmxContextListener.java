package com.zloyegor.mispi.lab4;

import com.zloyegor.mispi.lab4.management.DotChecker;
import com.zloyegor.mispi.lab4.management.MBeanListener;
import com.zloyegor.mispi.lab4.management.TimeSpanQualifier;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;

public class JmxContextListener implements ServletContextListener {

    private static final String dotCheckerMBeanName = "com.zloyegor.mispi.lab4:type=mbeans,name=dot_checker";
    private static final String timeSpanQualifierMBeanName = "com.zloyegor.mispi.lab4:type=mbeans,name=time_span_qualifier";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            ObjectName dotCheckerObjectName = new ObjectName(dotCheckerMBeanName);
            DotChecker dotChecker = DotChecker.getInstance();
            mBeanServer.registerMBean(dotChecker, dotCheckerObjectName);

            ObjectName timeSpanQualifierObjectName = new ObjectName(timeSpanQualifierMBeanName);
            TimeSpanQualifier timeSpanQualifier = TimeSpanQualifier.getInstance();
            mBeanServer.registerMBean(timeSpanQualifier, timeSpanQualifierObjectName);

            MBeanListener dotCheckerListener = new MBeanListener("dotChecker");
            mBeanServer.addNotificationListener(dotCheckerObjectName, dotCheckerListener, dotCheckerListener.getNotificationFilter(), null);
        } catch (Exception e) {
            System.err.println("Error registering MBean: " + e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

            ObjectName dotCheckerObjectName = new ObjectName(dotCheckerMBeanName);
            mBeanServer.unregisterMBean(dotCheckerObjectName);

            ObjectName timeSpanQualifierObjectName = new ObjectName(timeSpanQualifierMBeanName);
            mBeanServer.unregisterMBean(timeSpanQualifierObjectName);

        } catch (Exception e) {
            System.err.println("Error unregistering MBean: " + e);
        }
    }
}
