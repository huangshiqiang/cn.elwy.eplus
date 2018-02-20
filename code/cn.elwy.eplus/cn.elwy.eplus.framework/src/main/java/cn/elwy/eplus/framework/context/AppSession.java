package cn.elwy.eplus.framework.context;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.elwy.eplus.core.entity.User;
import cn.elwy.eplus.framework.context.exception.ExpiredSessionException;
import cn.elwy.eplus.framework.context.exception.InvalidSessionException;
import cn.elwy.eplus.framework.context.exception.StoppedSessionException;

/**
 * @description
 * @author huangsq
 * @version 1.0, 2018-02-19
 */
public class AppSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient static final Logger log = LoggerFactory.getLogger(AppSession.class);

	protected static final long MILLIS_PER_SECOND = 1000;
	protected static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
	protected static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

	public static final long DEFAULT_GLOBAL_SESSION_TIMEOUT = 30 * MILLIS_PER_MINUTE;

	private Serializable id;
	private User user;
	// private Appl appl;
	// private List<Role> roleList;
	// private List<Org> orgList;
	// private List<Group> groupList;
	// private List<FuncAuthority> userFuncList;
	// private Map<Role, List<FuncAuthority>> roleFuncMap;

	private Date startTimestamp;
	private Date stopTimestamp;
	private Date lastAccessTime;
	/** 会话超时时间 */
	private long timeout;
	/** 是否过期 */
	private boolean expired;
	private String host;
	private Map<Object, Object> attributes;

	public AppSession() {
		this.timeout = DEFAULT_GLOBAL_SESSION_TIMEOUT;
		this.startTimestamp = new Date();
		this.lastAccessTime = this.startTimestamp;
	}

	public AppSession(String host) {
		this();
		this.host = host;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// public Appl getAppl() {
	// return appl;
	// }
	//
	// public void setAppl(Appl appl) {
	// this.appl = appl;
	// }
	//
	// public List<Role> getRoleList() {
	// return roleList;
	// }
	//
	// public void setRoleList(List<Role> roleList) {
	// this.roleList = roleList;
	// }
	//
	// public List<Org> getOrgList() {
	// return orgList;
	// }
	//
	// public void setOrgList(List<Org> orgList) {
	// this.orgList = orgList;
	// }
	//
	// public List<Group> getGroupList() {
	// return groupList;
	// }
	//
	// public void setGroupList(List<Group> groupList) {
	// this.groupList = groupList;
	// }
	//
	// public List<FuncAuthority> getUserFuncList() {
	// return userFuncList;
	// }
	//
	// public void setUserFuncList(List<FuncAuthority> userFuncList) {
	// this.userFuncList = userFuncList;
	// }
	//
	// public Map<Role, List<FuncAuthority>> getRoleFuncMap() {
	// return roleFuncMap;
	// }
	//
	// public void setRoleFuncMap(Map<Role, List<FuncAuthority>> roleFuncMap) {
	// this.roleFuncMap = roleFuncMap;
	// }

	public Serializable getId() {
		return this.id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getStopTimestamp() {
		return stopTimestamp;
	}

	public void setStopTimestamp(Date stopTimestamp) {
		this.stopTimestamp = stopTimestamp;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Map<Object, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<Object, Object> attributes) {
		this.attributes = attributes;
	}

	public void touch() {
		this.lastAccessTime = new Date();
	}

	public void stop() {
		if (this.stopTimestamp == null) {
			this.stopTimestamp = new Date();
		}
	}

	protected boolean isStopped() {
		return getStopTimestamp() != null;
	}

	protected void expire() {
		stop();
		this.expired = true;
	}

	public boolean isValid() {
		return !isStopped() && !isExpired();
	}

	protected boolean isTimedOut() {

		if (isExpired()) {
			return true;
		}

		long timeout = getTimeout();

		if (timeout >= 0l) {

			Date lastAccessTime = getLastAccessTime();

			if (lastAccessTime == null) {
				String msg = "session.lastAccessTime for session with id [" + getId() + "] is null.  This code must be set at "
						+ "least once, preferably at least upon instantiation.  Please check the " + getClass().getName()
						+ " implementation and ensure " + "this code will be set (perhaps in the constructor?)";
				throw new IllegalStateException(msg);
			}

			// Calculate at what time a session would have been last accessed
			// for it to be expired at this point. In other words, subtract
			// from the current time the amount of time that a session can
			// be inactive before expiring. If the session was last accessed
			// before this time, it is expired.
			long expireTimeMillis = System.currentTimeMillis() - timeout;
			Date expireTime = new Date(expireTimeMillis);
			return lastAccessTime.before(expireTime);
		} else {
			if (log.isTraceEnabled()) {
				log.trace("No timeout for session with id [" + getId() + "].  Session is not considered expired.");
			}
		}

		return false;
	}

	public void validate() throws InvalidSessionException {
		// check for stopped:
		if (isStopped()) {
			// timestamp is set, so the session is considered stopped:
			String msg = "Session with id [" + getId() + "] has been "
					+ "explicitly stopped.  No further interaction under this session is " + "allowed.";
			throw new StoppedSessionException(msg);
		}

		// check for expiration
		if (isTimedOut()) {
			expire();

			// throw an exception explaining details of why it expired:
			Date lastAccessTime = getLastAccessTime();
			long timeout = getTimeout();

			Serializable sessionId = getId();

			DateFormat df = DateFormat.getInstance();
			String msg = "Session with id [" + sessionId + "] has expired. " + "Last access time: "
					+ df.format(lastAccessTime) + ".  Current time: " + df.format(new Date()) + ".  Session timeout is set to "
					+ timeout / MILLIS_PER_SECOND + " seconds (" + timeout / MILLIS_PER_MINUTE + " minutes)";
			if (log.isTraceEnabled()) {
				log.trace(msg);
			}
			throw new ExpiredSessionException(msg);
		}
	}

	private Map<Object, Object> getAttributesLazy() {
		Map<Object, Object> attributes = getAttributes();
		if (attributes == null) {
			attributes = new HashMap<Object, Object>();
			setAttributes(attributes);
		}
		return attributes;
	}

	public Collection<Object> getAttributeKeys() throws InvalidSessionException {
		Map<Object, Object> attributes = getAttributes();
		if (attributes == null) {
			return Collections.emptySet();
		}
		return attributes.keySet();
	}

	public Object getAttribute(Object key) {
		Map<Object, Object> attributes = getAttributes();
		if (attributes == null) {
			return null;
		}
		return attributes.get(key);
	}

	public void setAttribute(Object key, Object value) {
		if (value == null) {
			removeAttribute(key);
		} else {
			getAttributesLazy().put(key, value);
		}
	}

	public Object removeAttribute(Object key) {
		Map<Object, Object> attributes = getAttributes();
		if (attributes == null) {
			return null;
		} else {
			return attributes.remove(key);
		}
	}

	/**
	 * Returns {@code true} if the specified argument is an {@code instanceof}
	 * {@code AppSession} and both {@link #getId() id}s are equal. If the argument
	 * is a {@code AppSession} and either 'this' or the argument does not yet have
	 * an ID assigned, the code of {@link #onEquals(AppSession) onEquals} is
	 * returned, which does a necessary attribute-based comparison when IDs are not
	 * available.
	 * <p/>
	 * Do your best to ensure {@code AppSession} instances receive an ID very early
	 * in their lifecycle to avoid the more expensive attributes-based comparison.
	 * @param obj the object to compare with this one for equality.
	 * @return {@code true} if this object is equivalent to the specified argument,
	 *         {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof AppSession) {
			AppSession other = (AppSession) obj;
			Serializable thisId = getId();
			Serializable otherId = other.getId();
			if (thisId != null && otherId != null) {
				return thisId.equals(otherId);
			} else {
				// fall back to an attribute based comparison:
				return onEquals(other);
			}
		}
		return false;
	}

	/**
	 * Provides an attribute-based comparison (no ID comparison) - incurred
	 * <em>only</em> when 'this' or the session object being compared for equality
	 * do not have a session id.
	 * @param ss the AppSession instance to compare for equality.
	 * @return true if all the attributes, except the id, are equal to this object's
	 *         attributes.
	 * @since 1.0
	 */
	protected boolean onEquals(AppSession ss) {
		return (getStartTimestamp() != null ? getStartTimestamp().equals(ss.getStartTimestamp())
				: ss.getStartTimestamp() == null)
				&& (getStopTimestamp() != null ? getStopTimestamp().equals(ss.getStopTimestamp())
						: ss.getStopTimestamp() == null)
				&& (getLastAccessTime() != null ? getLastAccessTime().equals(ss.getLastAccessTime())
						: ss.getLastAccessTime() == null)
				&& (getTimeout() == ss.getTimeout()) && (isExpired() == ss.isExpired())
				&& (getHost() != null ? getHost().equals(ss.getHost()) : ss.getHost() == null)
				&& (getAttributes() != null ? getAttributes().equals(ss.getAttributes()) : ss.getAttributes() == null);
	}

	@Override
	public int hashCode() {
		Serializable id = getId();
		if (id != null) {
			return id.hashCode();
		}
		int hashCode = getStartTimestamp() != null ? getStartTimestamp().hashCode() : 0;
		hashCode = 31 * hashCode + (getStopTimestamp() != null ? getStopTimestamp().hashCode() : 0);
		hashCode = 31 * hashCode + (getLastAccessTime() != null ? getLastAccessTime().hashCode() : 0);
		hashCode = 31 * hashCode + Long.valueOf(Math.max(getTimeout(), 0)).hashCode();
		hashCode = 31 * hashCode + Boolean.valueOf(isExpired()).hashCode();
		hashCode = 31 * hashCode + (getHost() != null ? getHost().hashCode() : 0);
		hashCode = 31 * hashCode + (getAttributes() != null ? getAttributes().hashCode() : 0);
		return hashCode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName()).append(",id=").append(getId());
		return sb.toString();
	}

}
