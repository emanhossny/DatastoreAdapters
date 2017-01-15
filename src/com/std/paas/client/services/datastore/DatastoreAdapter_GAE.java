package com.std.paas.client.services.datastore;


/**
 * this is a specific adapter for the Blob storage generic API for Azure platform
 * @author eman
 *
 */

public class DatastoreAdapter_GAE {

	public java.lang.Object createEntity(java.lang.Object datastoreAccount,java.lang.String tableName,java.lang.String partitionKey,java.lang.String rowKey,java.util.HashMap properties){
		com.google.appengine.api.datastore.DatastoreService var1=(com.google.appengine.api.datastore.DatastoreService)datastoreAccount;
		com.google.appengine.api.datastore.Entity var2=com.std.paas.api.staticcode.HelperFunctionalities.getDynamicEntity4GAE(tableName,rowKey,properties);
		com.google.appengine.api.datastore.Key var3=var1.put(var2);
		return var3;
		}
		public java.lang.Object authenticateDS(java.lang.String manifestString){
		com.google.appengine.api.datastore.DatastoreService var1=com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService();
		return var1;
		}
		public com.std.paas.api.staticcode.HelperFunctionalities.GenericEntity retrieveEntity(java.lang.Object datastoreAccount,java.lang.String tableName,java.lang.String partitionKey,java.lang.String rowKey){
		try{
		com.google.appengine.api.datastore.DatastoreService var1=(com.google.appengine.api.datastore.DatastoreService)datastoreAccount;
		com.google.appengine.api.datastore.Key var2=com.google.appengine.api.datastore.KeyFactory.createKey(tableName,rowKey);
		com.google.appengine.api.datastore.Entity var3=var1.get(var2);
		com.std.paas.api.staticcode.HelperFunctionalities.GenericEntity var4=com.std.paas.api.staticcode.HelperFunctionalities.retrieveGenericEntity4GAE(var3);
		return var4;
		}catch (com.google.appengine.api.datastore.EntityNotFoundException e){
		 e.printStackTrace();
		}
		 return null;
		}
		public boolean deleteEntity(java.lang.Object datastoreAccount,java.lang.String tableName,java.lang.String partitionKey,java.lang.String rowKey){
		com.google.appengine.api.datastore.DatastoreService var1=(com.google.appengine.api.datastore.DatastoreService)datastoreAccount;
		com.google.appengine.api.datastore.Key var2=com.google.appengine.api.datastore.KeyFactory.createKey(tableName,rowKey);
		var1.delete(var2);
		return true;
		}

}
