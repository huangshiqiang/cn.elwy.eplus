/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package cn.elwy.eplus.framework.context;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.elwy.common.util.AssertUtil;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public abstract class ThreadContext {

	private static final Logger log = LoggerFactory.getLogger(ThreadContext.class);

	private static final String CLASS_NAME = ThreadContext.class.getName();
	public static final String APP_SESSION_KEY = CLASS_NAME + "_APP_SESSION_KEY";

	private static final ThreadLocal<Map<Object, Object>> resources = new InheritableThreadLocalMap<Map<Object, Object>>();

	protected ThreadContext() {
	}

	public static Map<Object, Object> getResources() {
		return resources != null ? new HashMap<Object, Object>(resources.get()) : null;
	}

	public static void setResources(Map<Object, Object> newResources) {
		if (AssertUtil.isEmpty(newResources)) {
			return;
		}
		resources.get().clear();
		resources.get().putAll(newResources);
	}

	private static Object getValue(Object key) {
		return resources.get().get(key);
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(Object key) {
		if (log.isTraceEnabled()) {
			String msg = "get() - in thread [" + Thread.currentThread().getName() + "]";
			log.trace(msg);
		}

		Object value = getValue(key);
		if ((value != null) && log.isTraceEnabled()) {
			String msg = "Retrieved code of type [" + value.getClass().getName() + "] for key [" + key + "] "
					+ "bound to thread [" + Thread.currentThread().getName() + "]";
			log.trace(msg);
		}
		return (T) value;
	}

	public static void put(Object key, Object value) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}

		if (value == null) {
			remove(key);
			return;
		}

		resources.get().put(key, value);

		if (log.isTraceEnabled()) {
			String msg = "Bound code of type [" + value.getClass().getName() + "] for key [" + key + "] to thread " + "["
					+ Thread.currentThread().getName() + "]";
			log.trace(msg);
		}
	}

	public static Object remove(Object key) {
		Object value = resources.get().remove(key);

		if ((value != null) && log.isTraceEnabled()) {
			String msg = "Removed code of type [" + value.getClass().getName() + "] for key [" + key + "]" + "from thread ["
					+ Thread.currentThread().getName() + "]";
			log.trace(msg);
		}

		return value;
	}

	public static void remove() {
		resources.remove();
	}

	public static AppSession getAppSession() {
		return (AppSession) get(APP_SESSION_KEY);
	}

	public static void bind(AppSession appSession) {
		if (appSession != null) {
			put(APP_SESSION_KEY, appSession);
		}
	}

	public static AppSession unbindAppSession() {
		return (AppSession) remove(APP_SESSION_KEY);
	}

	private static final class InheritableThreadLocalMap<T extends Map<Object, Object>>
			extends InheritableThreadLocal<Map<Object, Object>> {
		protected Map<Object, Object> initialValue() {
			return new HashMap<Object, Object>();
		}

		@SuppressWarnings({ "unchecked" })
		protected Map<Object, Object> childValue(Map<Object, Object> parentValue) {
			if (parentValue != null) {
				return (Map<Object, Object>) ((HashMap<Object, Object>) parentValue).clone();
			} else {
				return null;
			}
		}
	}
}
