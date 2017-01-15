package com.std.paas.client.services.datastore;


/**
 * this is a specific adapter for the Blob storage generic API for Azure platform
 * @author eman
 *
 */

public class DatastoreAdapter_Azure {

	public java.lang.Object createEntity(java.lang.Object datastoreAccount,java.lang.String tableName,java.lang.String partitionKey,java.lang.String rowKey,java.util.HashMap properties){
		try{
		com.microsoft.azure.storage.CloudStorageAccount var1=(com.microsoft.azure.storage.CloudStorageAccount)datastoreAccount;
		com.microsoft.azure.storage.table.CloudTableClient var2=var1.createCloudTableClient();
		com.microsoft.azure.storage.table.CloudTable var3=var2.getTableReference(tableName);
		boolean var4=var3.createIfNotExists();
		com.microsoft.azure.storage.table.DynamicTableEntity var5=com.std.paas.api.staticcode.HelperFunctionalities.getDynamicEntity4Azure(partitionKey,rowKey,properties);
		com.microsoft.azure.storage.table.TableOperation var6=com.microsoft.azure.storage.table.TableOperation.insertOrReplace(var5);
		com.microsoft.azure.storage.table.TableResult var7=var3.execute(var6);
		return var7;
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}
		 return null;
		}
		public java.lang.Object authenticateDS(java.lang.String manifestString){
		try{
		java.lang.String var1=com.std.paas.api.staticcode.HelperFunctionalities.parse4Azure(manifestString);
		com.microsoft.azure.storage.CloudStorageAccount var2=com.microsoft.azure.storage.CloudStorageAccount.parse(var1);
		return var2;
		}catch (java.security.InvalidKeyException e){
		 e.printStackTrace();
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}
		 return null;
		}
		public com.std.paas.api.staticcode.HelperFunctionalities.GenericEntity retrieveEntity(java.lang.Object datastoreAccount,java.lang.String tableName,java.lang.String partitionKey,java.lang.String rowKey){
		try{
		com.microsoft.azure.storage.CloudStorageAccount var1=(com.microsoft.azure.storage.CloudStorageAccount)datastoreAccount;
		com.microsoft.azure.storage.table.CloudTableClient var2=var1.createCloudTableClient();
		com.microsoft.azure.storage.table.CloudTable var3=var2.getTableReference(tableName);
		java.lang.Class<com.microsoft.azure.storage.table.DynamicTableEntity> var4=com.std.paas.api.staticcode.HelperFunctionalities.getDynamicTableEntityMD4Azure();
		com.microsoft.azure.storage.table.TableOperation var5=com.microsoft.azure.storage.table.TableOperation.retrieve(tableName,rowKey,var4);
		com.microsoft.azure.storage.table.TableResult var6=var3.execute(var5);
		com.std.paas.api.staticcode.HelperFunctionalities.GenericEntity var7=com.std.paas.api.staticcode.HelperFunctionalities.retrieveGenericEntity4Azure(var6,tableName,partitionKey,rowKey);
		return var7;
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}
		 return null;
		}

		public boolean deleteEntity(java.lang.Object datastoreAccount,java.lang.String tableName,java.lang.String partitionKey,java.lang.String rowKey){
		try{
		com.microsoft.azure.storage.CloudStorageAccount var1=(com.microsoft.azure.storage.CloudStorageAccount)datastoreAccount;
		com.microsoft.azure.storage.table.CloudTableClient var2=var1.createCloudTableClient();
		com.microsoft.azure.storage.table.CloudTable var3=var2.getTableReference(tableName);
		java.lang.Class<com.microsoft.azure.storage.table.DynamicTableEntity> var4=com.std.paas.api.staticcode.HelperFunctionalities.getDynamicTableEntityMD4Azure();
		com.microsoft.azure.storage.table.TableOperation var5=com.microsoft.azure.storage.table.TableOperation.retrieve(tableName,rowKey,var4);
		com.microsoft.azure.storage.table.TableResult var6=var3.execute(var5);
		com.microsoft.azure.storage.table.DynamicTableEntity var7=var6.getResultAsType();
		com.microsoft.azure.storage.table.TableOperation var8=com.microsoft.azure.storage.table.TableOperation.delete(var7);
		var6=var3.execute(var8);
		return true;
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}
		 return false;
		}
}
