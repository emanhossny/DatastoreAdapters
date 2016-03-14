package com.std.paas.client.services.persistent.storage.azure;


/**
 * this is a specific adapter for the Blob storage generic API for Azue platform
 * @author eman
 *
 */

public class BlobStorageAdapter {

	public boolean deleteBlob(java.lang.Object storageAccount,java.lang.String containerName,java.lang.String blobName){
		try{
		com.microsoft.azure.storage.CloudStorageAccount var1=(com.microsoft.azure.storage.CloudStorageAccount)storageAccount;
		com.microsoft.azure.storage.blob.CloudBlobClient var2=var1.createCloudBlobClient();
		com.microsoft.azure.storage.blob.CloudBlobContainer var3=var2.getContainerReference(containerName);
		com.microsoft.azure.storage.blob.CloudBlockBlob var4=var3.getBlockBlobReference(blobName);
		boolean var5=var4.deleteIfExists();
		return var5;
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}
		 return false;
		}
		public boolean downloadBlob(java.lang.Object storageAccount,java.lang.String containerName,java.lang.String blobName,java.io.OutputStream outputStream,long startPosition){
		try{
		com.microsoft.azure.storage.CloudStorageAccount var1=(com.microsoft.azure.storage.CloudStorageAccount)storageAccount;
		com.microsoft.azure.storage.blob.CloudBlobClient var2=var1.createCloudBlobClient();
		com.microsoft.azure.storage.blob.CloudBlobContainer var3=var2.getContainerReference(containerName);
		com.microsoft.azure.storage.blob.CloudBlockBlob var4=var3.getBlockBlobReference(blobName);
		var4.download(outputStream);
		return true;
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}
		 return false;
		}
		public java.util.Iterator<com.std.paas.api.staticcode.HelperFunctionalities.GenericBlob> listBlobs(java.lang.Object storageAccount,java.lang.String containerName){
		try{
		com.microsoft.azure.storage.CloudStorageAccount var1=(com.microsoft.azure.storage.CloudStorageAccount)storageAccount;
		com.microsoft.azure.storage.blob.CloudBlobClient var2=var1.createCloudBlobClient();
		com.microsoft.azure.storage.blob.CloudBlobContainer var3=var2.getContainerReference(containerName);
		java.util.Iterator<com.std.paas.api.staticcode.HelperFunctionalities.GenericBlob> var4=com.std.paas.api.staticcode.HelperFunctionalities.listBlobs4Azure(var3,containerName);
		return var4;
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}
		 return null;
		}
		public java.lang.Object authenticate(java.lang.String manifestString){
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
		public java.lang.Object createBlob(java.lang.String contentType,java.lang.Object storageAccount,java.lang.String containerName,java.lang.String blobName,com.std.paas.api.staticcode.HelperFunctionalities.AccessRights accessRights){
		try{
		com.microsoft.azure.storage.CloudStorageAccount var1=(com.microsoft.azure.storage.CloudStorageAccount)storageAccount;
		com.microsoft.azure.storage.blob.CloudBlobClient var2=var1.createCloudBlobClient();
		com.microsoft.azure.storage.blob.CloudBlobContainer var3=var2.getContainerReference(containerName);
		boolean var4=var3.createIfNotExists();
		com.microsoft.azure.storage.blob.BlobContainerPublicAccessType var5=com.std.paas.api.staticcode.HelperFunctionalities.getAccessRights4Azure(accessRights);
		com.microsoft.azure.storage.blob.BlobContainerPermissions var6=new com.microsoft.azure.storage.blob.BlobContainerPermissions();
		var6.setPublicAccess(var5);
		var3.uploadPermissions(var6);
		com.microsoft.azure.storage.blob.CloudBlockBlob var7=var3.getBlockBlobReference(blobName);
		return var7;
		}catch (java.net.URISyntaxException e){
		 e.printStackTrace();
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}
		 return null;
		}
		public boolean uploadBlob(java.lang.Object blob,java.io.InputStream inputStream){
		try{
		com.microsoft.azure.storage.blob.CloudBlockBlob var1=(com.microsoft.azure.storage.blob.CloudBlockBlob)blob;
		com.microsoft.azure.storage.blob.BlobOutputStream var2=var1.openOutputStream();
		boolean var3=com.std.paas.api.staticcode.HelperFunctionalities.copy(inputStream,var2);
		return var3;
		}catch (com.microsoft.azure.storage.StorageException e){
		 e.printStackTrace();
		}
		 return false;
		}
}
