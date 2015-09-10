// This file was generated by Mendix Business Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package system.proxies;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * 
 */
public class Session
{
	private final IMendixObject sessionMendixObject;

	private final IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final String entityName = "System.Session";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		SessionId("SessionId"),
		LastActive("LastActive"),
		Session_User("System.Session_User");

		private String metaName;

		MemberNames(String s)
		{
			metaName = s;
		}

		@Override
		public String toString()
		{
			return metaName;
		}
	}

	public Session(IContext context)
	{
		this(context, Core.instantiate(context, "System.Session"));
	}

	protected Session(IContext context, IMendixObject sessionMendixObject)
	{
		if (sessionMendixObject == null)
			throw new IllegalArgumentException("The given object cannot be null.");
		if (!Core.isSubClassOf("System.Session", sessionMendixObject.getType()))
			throw new IllegalArgumentException("The given object is not a System.Session");

		this.sessionMendixObject = sessionMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Session.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static system.proxies.Session initialize(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		return system.proxies.Session.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.getSudoContext() can be used to obtain sudo access).
	 */
	public static system.proxies.Session initialize(IContext context, IMendixObject mendixObject)
	{
		return new system.proxies.Session(context, mendixObject);
	}

	public static system.proxies.Session load(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		IMendixObject mendixObject = Core.retrieveId(context, mendixIdentifier);
		return system.proxies.Session.initialize(context, mendixObject);
	}

	public static java.util.List<system.proxies.Session> load(IContext context, String xpathConstraint) throws CoreException
	{
		java.util.List<system.proxies.Session> result = new java.util.ArrayList<system.proxies.Session>();
		for (IMendixObject obj : Core.retrieveXPathQuery(context, "//System.Session" + xpathConstraint))
			result.add(system.proxies.Session.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws CoreException
	{
		Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(IContext context) throws CoreException
	{
		Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(IContext context)
	{
		Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of SessionId
	 */
	public final String getSessionId()
	{
		return getSessionId(getContext());
	}

	/**
	 * @param context
	 * @return value of SessionId
	 */
	public final String getSessionId(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.SessionId.toString());
	}

	/**
	 * Set value of SessionId
	 * @param sessionid
	 */
	public final void setSessionId(String sessionid)
	{
		setSessionId(getContext(), sessionid);
	}

	/**
	 * Set value of SessionId
	 * @param context
	 * @param sessionid
	 */
	public final void setSessionId(IContext context, String sessionid)
	{
		getMendixObject().setValue(context, MemberNames.SessionId.toString(), sessionid);
	}

	/**
	 * @return value of LastActive
	 */
	public final java.util.Date getLastActive()
	{
		return getLastActive(getContext());
	}

	/**
	 * @param context
	 * @return value of LastActive
	 */
	public final java.util.Date getLastActive(IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.LastActive.toString());
	}

	/**
	 * Set value of LastActive
	 * @param lastactive
	 */
	public final void setLastActive(java.util.Date lastactive)
	{
		setLastActive(getContext(), lastactive);
	}

	/**
	 * Set value of LastActive
	 * @param context
	 * @param lastactive
	 */
	public final void setLastActive(IContext context, java.util.Date lastactive)
	{
		getMendixObject().setValue(context, MemberNames.LastActive.toString(), lastactive);
	}

	/**
	 * @return value of Session_User
	 */
	public final system.proxies.User getSession_User() throws CoreException
	{
		return getSession_User(getContext());
	}

	/**
	 * @param context
	 * @return value of Session_User
	 */
	public final system.proxies.User getSession_User(IContext context) throws CoreException
	{
		system.proxies.User result = null;
		IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Session_User.toString());
		if (identifier != null)
			result = system.proxies.User.load(context, identifier);
		return result;
	}

	/**
	 * Set value of Session_User
	 * @param session_user
	 */
	public final void setSession_User(system.proxies.User session_user)
	{
		setSession_User(getContext(), session_user);
	}

	/**
	 * Set value of Session_User
	 * @param context
	 * @param session_user
	 */
	public final void setSession_User(IContext context, system.proxies.User session_user)
	{
		if (session_user == null)
			getMendixObject().setValue(context, MemberNames.Session_User.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.Session_User.toString(), session_user.getMendixObject().getId());
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final IMendixObject getMendixObject()
	{
		return sessionMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final IContext getContext()
	{
		return context;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final system.proxies.Session that = (system.proxies.Session) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static String getType()
	{
		return "System.Session";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Deprecated
	public String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
