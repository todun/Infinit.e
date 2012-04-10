/*******************************************************************************
 * Copyright 2012, The Infinit.e Open Source Project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.ikanow.infinit.e.data_model.store.config.source;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;

import sun.misc.BASE64Encoder;

import com.google.gson.reflect.TypeToken;
import com.ikanow.infinit.e.data_model.store.BaseDbPojo;
import com.ikanow.infinit.e.data_model.store.social.authentication.AuthenticationPojo;
import com.mongodb.BasicDBObject;

/**
 * Class used to establish the source information for a feed
 * this defines the data necessary to create a feed in the system
 * 
 * @author cmorgan
 *
 */

public class SourcePojo extends BaseDbPojo {
	// Standard static function for readability
	@SuppressWarnings("unchecked")
	static public TypeToken<List<SourcePojo>> listType() { return new TypeToken<List<SourcePojo>>(){}; }

	/** 
	  * Private Class Variables
	  */
	private ObjectId _id = null;
	final public static String _id_ = "_id";
	private Date created = null;
	final public static String created_ = "created";
	private Date modified = null;
	final public static String modified_ = "modified";
	private String url = null;
	final public static String url_ = "url";
	private String title = null;
	final public static String title_ = "title";
	private boolean isPublic = true;
	final public static String isPublic_ = "isPublic";
	private ObjectId ownerId = null;
	final public static String ownerId_ = "ownerId";
	private String author = null;
	final public static String author_ = "author";
	
	private AuthenticationPojo authentication = null;
	final public static String authentication_ = "authentication";
	
	private String mediaType = null;
	final public static String mediaType_ = "mediaType";
	private String key = null;
	final public static String key_ = "key";
	private String description = null;
	final public static String description_ = "description";
	private Set<String> tags = null;
	final public static String tags_ = "tags";
	
	private Set<ObjectId> communityIds = null;
	final public static String communityIds_ = "communityIds";
	
	private SourceHarvestStatusPojo harvest = null;
	final public static String harvest_ = "harvest";
	private SourceDatabaseConfigPojo database = null;
	final public static String database_ = "database";
	private SourceFileConfigPojo file = null;
	final public static String file_ = "file";
	private SourceRssConfigPojo rss = null;
	final public static String rss_ = "rss";
	
	private boolean isApproved = false;
	final public static String isApproved_ = "isApproved";
	private boolean harvestBadSource = false;
	final public static String harvestBadSource_ = "harvestBadSource";
	
	private String extractType = null;
	final public static String extractType_ = "extractType";
	private String useExtractor = null;
	final public static String useExtractor_ = "useExtractor";
	private String useTextExtractor = null;
	final public static String useTextExtractor_ = "useTextExtractor";
	
	private StructuredAnalysisConfigPojo structuredAnalysis = null;
	final public static String structuredAnalysis_ = "structuredAnalysis";
	private UnstructuredAnalysisConfigPojo unstructuredAnalysis = null;
	final public static String unstructuredAnalysis_ = "unstructuredAnalysis";
	
	private String shah256Hash = null;	
	final public static String shah256Hash_ = "shah256Hash";

	private Integer searchCycle_secs = null; // Determines the time between searches, defaults as quickly as the harvest can cycle
	final public static String searchCycle_secs_ = "searchCycle_secs";
	
	// Gets and sets
	
	public AuthenticationPojo getAuthentication() {
		return authentication;
	}
	public void setAuthentication(AuthenticationPojo authentication) {
		this.authentication = authentication;
	}
	public SourceFileConfigPojo getFileConfig() {
		return file;
	}
	public void setFileConfig(SourceFileConfigPojo file) {
		this.file = file;
	}
	public SourceRssConfigPojo getRssConfig() {
		return rss;
	}
	public void setRssConfig(SourceRssConfigPojo rss) {
		this.rss = rss;
	}
	public SourceDatabaseConfigPojo getDatabaseConfig() {
		return database;
	}
	public void setDatabaseConfig(SourceDatabaseConfigPojo database) {
		this.database = database;
	}
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
		generateSourceKey();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getExtractType() {
		return extractType;
	}
	public void setExtractType(String extractType) {
		this.extractType = extractType;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	/** 
	  * Get the tags
	  */
	public Set<String> getTags() {
		return tags;
	}
	/** 
	  * Set the tags
	  */
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	/**
	 * @param ownerID the ownerID to set
	 */
	public void setOwnerId(ObjectId ownerID) {
		this.ownerId = ownerID;
	}
	/**
	 * @return the ownerID
	 */
	public ObjectId getOwnerId() {
		return ownerId;
	}
	public SourcePojo() {
		
	}
	public void setHarvestStatus(SourceHarvestStatusPojo harvest) {
		this.harvest = harvest;
	}
	public SourceHarvestStatusPojo getHarvestStatus() {
		return harvest;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void addToCommunityIds(ObjectId communityID) {
		if (null == this.communityIds) {
			this.communityIds = new HashSet<ObjectId>();
		}
		this.communityIds.add(communityID);
	}
	public void removeFromCommunityIds(ObjectId communityID) {
		if (null != this.communityIds) {
			this.communityIds.remove(communityID);
		}
	}
	public Set<ObjectId> getCommunityIds() {
		return communityIds;
	}
	public void setCommunityIds(Set<ObjectId> ids) {
		communityIds = ids;
	}
	public void setHarvestBadSource(boolean harvestBadSource) {
		this.harvestBadSource = harvestBadSource;
	}
	public boolean isHarvestBadSource() {
		return harvestBadSource;
	}

	/**
	 * @param useExtractor the useExtractor to set
	 */
	public void setUseExtractor(String useExtractor) {
		this.useExtractor = useExtractor;
	}

	/**
	 * @return the useExtractor
	 */
	public String useExtractor() {
		return useExtractor;
	}

	/**
	 * @param useTextExtractor the useTextExtractor to set
	 */
	public void setUseTextExtractor(String useTextExtractor) {
		this.useTextExtractor = useTextExtractor;
	}

	/**
	 * @return the useTextExtractor
	 */
	public String useTextExtractor() {
		return useTextExtractor;
	}

	/**
	 * @param structedAnalysis the structedAnalysis to set
	 */
	public void setStructuredAnalysisConfig(StructuredAnalysisConfigPojo structuredAnalysis) {
		this.structuredAnalysis = structuredAnalysis;
	}

	/**
	 * @return the structedAnalysis
	 */
	public StructuredAnalysisConfigPojo getStructuredAnalysisConfig() {
		return structuredAnalysis;
	}
	
	/**
	 * @param structuredAnalysis the structuredAnalysis to set
	 */
	public void setUnstructuredAnalysisConfig(UnstructuredAnalysisConfigPojo unstructuredAnalysis) {
		this.unstructuredAnalysis = unstructuredAnalysis;
	}

	/**
	 * @return the unstructuredAnalysis
	 */
	public UnstructuredAnalysisConfigPojo getUnstructuredAnalysisConfig() {
		return unstructuredAnalysis;
	}
	/**
	 * setShah256Hash - calls generateShah256Hash
	 */
	public void generateShah256Hash()
	{
		try 
		{
			generateShah256Hash_internal();
		} 
		catch (Exception e) 
		{
			
		}
	}

	/**
	 * getShah256Hash - calls generateShah256Hash if shah256Hash is null
	 * @return
	 */
	public String getShah256Hash() 
	{
		if (null != shah256Hash )
		{
			return shah256Hash;
		}
		else
		{
			try 
			{
				generateShah256Hash_internal();
				return shah256Hash;
			} 
			catch (Exception e) 
			{
				return null;
			}
		}
	}
	// Utility:
	
	/**
	 * generateSourceKey
	 * Strips out http://, smb:// /, :, etc. from the URL field to generate
	 * Example: http://www.ikanow.com/rss -> www.ikanow.com.rss
	 */
	private void generateSourceKey()
	{
		String s;
		if (null != this.url) {
			s = this.url.toLowerCase();			
		}
		else {
			s = this.rss.getExtraUrls().get(0).url; // (going to bomb out if any of this doesn't exist anyway)
		}
		s = s.replaceAll("http://|https://|smb://|ftp://|ftps://|file://|[/:+?&(),]", ".");
		if (s.startsWith(".")) s = s.substring(1);
		this.key = s;
	}
	/**
	 * generateShah256Hash
	 * Combines the required and optional fields of a SourcePojo into a string that is
	 * then hashed using SHAH-256 and saved to the SourePojo.shah256Hash field;
	 * this value is used to determine source uniqueness
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	private void generateShah256Hash_internal() throws NoSuchAlgorithmException, UnsupportedEncodingException 
	{	
		// Create StringBuffer with fields to use to establish source *processing* uniqueness
		StringBuffer sb = new StringBuffer();

		// (Note what I mean by "source processing uniqueness" is that, *for a specific doc URL* 2 sources would process it identically)
		
		// So fields like key,URL,media type,tags,etc aren't included in the hash
		
		// Required Fields
		sb.append(this.extractType);
				
		// Optional fields
		if (this.extractType != null) sb.append(this.extractType);
		if (this.useExtractor != null) sb.append(this.useExtractor);
		if (this.useTextExtractor != null) sb.append(this.useTextExtractor);
		
		// Generate a hash of all the objects using the ORM layer
		SourcePojo newSrc = new SourcePojo();
		newSrc.setId(null); // (in case this is auto set by the c'tor)
		newSrc.setAuthentication(this.authentication);
		newSrc.setDatabaseConfig(this.database);
		newSrc.setFileConfig(this.file);
		newSrc.setRssConfig(this.rss);
		newSrc.setStructuredAnalysisConfig(this.structuredAnalysis);
		newSrc.setUnstructuredAnalysisConfig(this.unstructuredAnalysis);
		sb.append(((BasicDBObject)newSrc.toDb()).toString());
		
		// Create MessageDigest and set shah256Hash value
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(sb.toString().getBytes("UTF-8"));		
		shah256Hash = (new BASE64Encoder()).encode(md.digest());	
	}
	public Integer getSearchCycle_secs() {
		return searchCycle_secs;
	}
	public void setSearchCycle_secs(Integer searchCycle_secs) {
		this.searchCycle_secs = searchCycle_secs;
	}	
}