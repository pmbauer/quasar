/*
 * Copyright (C) 2011-2013, Parallel Universe Software Co. All rights reserved.
 * 
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *  
 *   or (per the licensee's choosing)
 *  
 * under the terms of the GNU Lesser General Public License version 3.0
 * as published by the Free Software Foundation.
 */
package co.paralleluniverse.common.monitoring;

/**
 *
 * @author pron
 */
public interface ForkJoinPoolMXBean {
    public static enum Status {
        ACTIVE, QUIESCENT, SHUTDOWN, TERMINATING, TERMINATED
    }

    boolean getAsyncMode();

    int getParalellism();

    int getPoolSize();

    Status getStatus();

    int getActiveThreadCount();

    int getRunningThreadCount();

    int getQueuedSubmissionCount();

    long getQueuedTaskCount();

    long getStealCount();

    ForkJoinInfo getInfo();

    void shutdown();

    void shutdownNow();
}
