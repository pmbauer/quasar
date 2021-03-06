/*
 * Copyright (c) 2013, Parallel Universe Software Co. All rights reserved.
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
package co.paralleluniverse.common.benchmark;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import jsr166e.ConcurrentHashMapV8;

/**
 *
 * @author pron
 */
public abstract class StripedResource<T> implements Iterable<T> {
    private final ConcurrentMap<Thread, T> rs;

    public StripedResource() {
        this.rs = new ConcurrentHashMapV8<>();
    }

    public Collection<T> combine() {
        return rs.values();
    }

    public T get() {
        Thread thread = Thread.currentThread();
        T r = rs.get(thread);
        if (r == null) {
            r = newResource();
            rs.put(thread, r);
        }
        return r;
    }

    protected abstract T newResource();

    @Override
    public Iterator<T> iterator() {
        return rs.values().iterator();
    }
    
    public int size() {
        return rs.size();
    }
}
