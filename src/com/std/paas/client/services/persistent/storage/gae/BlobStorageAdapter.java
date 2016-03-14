package com.std.paas.client.services.persistent.storage.gae;

public class BlobStorageAdapter {
	public boolean downloadBlob(java.lang.Object storageAccount,java.lang.String containerName,java.lang.String blobName,java.io.OutputStream outputStream,long startPosition){
		try{
		com.google.appengine.tools.cloudstorage.GcsService var1=(com.google.appengine.tools.cloudstorage.GcsService)storageAccount;
		com.google.appengine.tools.cloudstorage.GcsFilename var2=new com.google.appengine.tools.cloudstorage.GcsFilename(containerName,blobName);
		com.google.appengine.tools.cloudstorage.GcsInputChannel var3=var1.openReadChannel(var2,startPosition);
		java.io.InputStream var4=java.nio.channels.Channels.newInputStream(var3);
		boolean var5=com.std.paas.api.staticcode.HelperFunctionalities.copy(var4,outputStream);
		return var5;
		}catch (java.io.IOException e){
		 e.printStackTrace();
		}
		 return false;
		}
		public java.util.Iterator<com.std.paas.api.staticcode.HelperFunctionalities.GenericBlob> listBlobs(java.lang.Object storageAccount,java.lang.String containerName){
		com.google.appengine.tools.cloudstorage.GcsService var1=(com.google.appengine.tools.cloudstorage.GcsService)storageAccount;
		java.util.Iterator<com.std.paas.api.staticcode.HelperFunctionalities.GenericBlob> var2=com.std.paas.api.staticcode.HelperFunctionalities.listBlobs4GCS(var1,containerName);
		return var2;
		}
		public java.lang.Object createBlob(java.lang.String contentType,java.lang.Object storageAccount,java.lang.String containerName,java.lang.String blobName,com.std.paas.api.staticcode.HelperFunctionalities.AccessRights accessRights){
		try{
		com.google.appengine.tools.cloudstorage.GcsService var1=(com.google.appengine.tools.cloudstorage.GcsService)storageAccount;
		com.google.appengine.tools.cloudstorage.GcsFileOptions.Builder var2=new com.google.appengine.tools.cloudstorage.GcsFileOptions.Builder();
		var2=var2.mimeType(contentType);
		java.lang.String var3=com.std.paas.api.staticcode.HelperFunctionalities.getAccessRights4GCS(accessRights);
		var2=var2.acl(var3);
		com.google.appengine.tools.cloudstorage.GcsFileOptions var4=var2.build();
		com.google.appengine.tools.cloudstorage.GcsFilename var5=new com.google.appengine.tools.cloudstorage.GcsFilename(containerName,blobName);
		com.google.appengine.tools.cloudstorage.GcsOutputChannel var6=var1.createOrReplace(var5,var4);
		return var6;
		}catch (java.io.IOException e){
		 e.printStackTrace();
		}
		 return null;
		}
		public boolean deleteBlob(java.lang.Object storageAccount,java.lang.String containerName,java.lang.String blobName){
		try{
		com.google.appengine.tools.cloudstorage.GcsService var1=(com.google.appengine.tools.cloudstorage.GcsService)storageAccount;
		com.google.appengine.tools.cloudstorage.GcsFilename var2=new com.google.appengine.tools.cloudstorage.GcsFilename(containerName,blobName);
		boolean var3=var1.delete(var2);
		return var3;
		}catch (java.io.IOException e){
		 e.printStackTrace();
		}
		 return false;
		}
		public java.lang.Object authenticate(java.lang.String manifestString){
		com.google.appengine.tools.cloudstorage.RetryParams var1=com.google.appengine.tools.cloudstorage.RetryParams.getDefaultInstance();
		com.google.appengine.tools.cloudstorage.GcsService var2=com.google.appengine.tools.cloudstorage.GcsServiceFactory.createGcsService(var1);
		return var2;
		}
		public boolean uploadBlob(java.lang.Object blob,java.io.InputStream inputStream){
		com.google.appengine.tools.cloudstorage.GcsOutputChannel var1=(com.google.appengine.tools.cloudstorage.GcsOutputChannel)blob;
		java.io.OutputStream var2=java.nio.channels.Channels.newOutputStream(var1);
		boolean var3=com.std.paas.api.staticcode.HelperFunctionalities.copy(inputStream,var2);
		return var3;
		}


}
