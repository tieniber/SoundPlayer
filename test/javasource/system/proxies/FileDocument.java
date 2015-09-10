// This file was generated by Mendix Business Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package system.proxies;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.core.objectmanagement.member.MendixBinary;

/**
 * 
 */
public class FileDocument
{
	private final IMendixObject fileDocumentMendixObject;

	private final IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final String entityName = "System.FileDocument";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		FileID("FileID"),
		Name("Name"),
		DeleteAfterDownload("DeleteAfterDownload"),
		Contents("Contents"),
		HasContents("HasContents");

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

	public FileDocument(IContext context)
	{
		this(context, Core.instantiate(context, "System.FileDocument"));
	}

	protected FileDocument(IContext context, IMendixObject fileDocumentMendixObject)
	{
		if (fileDocumentMendixObject == null)
			throw new IllegalArgumentException("The given object cannot be null.");
		if (!Core.isSubClassOf("System.FileDocument", fileDocumentMendixObject.getType()))
			throw new IllegalArgumentException("The given object is not a System.FileDocument");

		this.fileDocumentMendixObject = fileDocumentMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'FileDocument.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static system.proxies.FileDocument initialize(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		return system.proxies.FileDocument.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.getSudoContext() can be used to obtain sudo access).
	 */
	public static system.proxies.FileDocument initialize(IContext context, IMendixObject mendixObject)
	{
		if (Core.isSubClassOf("TestSuite.Color", mendixObject.getType()))
			return testsuite.proxies.Color.initialize(context, mendixObject);

		if (Core.isSubClassOf("System.Image", mendixObject.getType()))
			return system.proxies.Image.initialize(context, mendixObject);

		return new system.proxies.FileDocument(context, mendixObject);
	}

	public static system.proxies.FileDocument load(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		IMendixObject mendixObject = Core.retrieveId(context, mendixIdentifier);
		return system.proxies.FileDocument.initialize(context, mendixObject);
	}

	public static java.util.List<? extends system.proxies.FileDocument> load(IContext context, String xpathConstraint) throws CoreException
	{
		java.util.List<system.proxies.FileDocument> result = new java.util.ArrayList<system.proxies.FileDocument>();
		for (IMendixObject obj : Core.retrieveXPathQuery(context, "//System.FileDocument" + xpathConstraint))
			result.add(system.proxies.FileDocument.initialize(context, obj));
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
	 * @return value of FileID
	 */
	public final Long getFileID()
	{
		return getFileID(getContext());
	}

	/**
	 * @param context
	 * @return value of FileID
	 */
	public final Long getFileID(IContext context)
	{
		return (Long) getMendixObject().getValue(context, MemberNames.FileID.toString());
	}

	/**
	 * Set value of FileID
	 * @param fileid
	 */
	public final void setFileID(Long fileid)
	{
		setFileID(getContext(), fileid);
	}

	/**
	 * Set value of FileID
	 * @param context
	 * @param fileid
	 */
	public final void setFileID(IContext context, Long fileid)
	{
		getMendixObject().setValue(context, MemberNames.FileID.toString(), fileid);
	}

	/**
	 * @return value of Name
	 */
	public final String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final String getName(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(IContext context, String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @return value of DeleteAfterDownload
	 */
	public final Boolean getDeleteAfterDownload()
	{
		return getDeleteAfterDownload(getContext());
	}

	/**
	 * @param context
	 * @return value of DeleteAfterDownload
	 */
	public final Boolean getDeleteAfterDownload(IContext context)
	{
		return (Boolean) getMendixObject().getValue(context, MemberNames.DeleteAfterDownload.toString());
	}

	/**
	 * Set value of DeleteAfterDownload
	 * @param deleteafterdownload
	 */
	public final void setDeleteAfterDownload(Boolean deleteafterdownload)
	{
		setDeleteAfterDownload(getContext(), deleteafterdownload);
	}

	/**
	 * Set value of DeleteAfterDownload
	 * @param context
	 * @param deleteafterdownload
	 */
	public final void setDeleteAfterDownload(IContext context, Boolean deleteafterdownload)
	{
		getMendixObject().setValue(context, MemberNames.DeleteAfterDownload.toString(), deleteafterdownload);
	}

	/**
	  * The contents of the binary field will be written to the output stream.
	  * The output stream will be closed at the end.
	  *
	  * @param context
	  * @param outputStream
	  */
	public final void getContents(IContext context, java.io.OutputStream outputStream)
	{
		MendixBinary binary = (MendixBinary) getMendixObject().getMember(context, MemberNames.Contents.toString());
		binary.retrieveValue(context, outputStream);
	}

	/**
	  * Stores the bytes from the given InputStream.
	  *
	  * Please note that the input stream will be immediately sent to the data store,
	  * whether you commit the Mendix object or not.
	  *
	  * @param context
	  * @param inputStream
	  * @param length the number of bytes in the stream
	  */
	public final void setContents(IContext context, java.io.InputStream inputStream, long length)
	{
		if (getMendixObject().getState() == IMendixObject.ObjectState.INSTANTIATED)
			try { commit(); } catch (CoreException ex) { }
		MendixBinary binary = (MendixBinary) getMendixObject().getMember(context, MemberNames.Contents.toString());
		binary.storeValue(context, inputStream, length);
	}

	/**
	 * @return value of HasContents
	 */
	public final Boolean getHasContents()
	{
		return getHasContents(getContext());
	}

	/**
	 * @param context
	 * @return value of HasContents
	 */
	public final Boolean getHasContents(IContext context)
	{
		return (Boolean) getMendixObject().getValue(context, MemberNames.HasContents.toString());
	}

	/**
	 * Set value of HasContents
	 * @param hascontents
	 */
	public final void setHasContents(Boolean hascontents)
	{
		setHasContents(getContext(), hascontents);
	}

	/**
	 * Set value of HasContents
	 * @param context
	 * @param hascontents
	 */
	public final void setHasContents(IContext context, Boolean hascontents)
	{
		getMendixObject().setValue(context, MemberNames.HasContents.toString(), hascontents);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final IMendixObject getMendixObject()
	{
		return fileDocumentMendixObject;
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
			final system.proxies.FileDocument that = (system.proxies.FileDocument) obj;
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
		return "System.FileDocument";
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
