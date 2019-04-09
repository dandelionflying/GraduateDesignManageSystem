package com.running4light.gdms.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FileUtil {
	/*
	 * 上传文件到FTP服务器
	 * host FTP服务器hostname
	 * port 端口
	 * username FTP服务器登录账号
	 * password FTP服务器登录密码 
	 * basePath FTP服务器基础目录
	 * filePath FTP服务器文件存放路径
	 * filename 上传到FTP服务器上的文件名
	 * input 文件输入流
	 */
	public static boolean uploadFile(String host,int port,String username,String password,String basePath,
			String filePath,String filename,InputStream input) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(host, port);
			ftp.login(username, password);
			reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return result;
			}
			//切换到上传目录
			if(!ftp.changeWorkingDirectory(basePath+filename)) {
				//创建目录
				String[] dirs = filePath.split("/");
				String tempPath = basePath;
				for (String dir : dirs) {
					if(null == dir || "".equals(dir))
						continue;
					tempPath += "/"+dir;
					if(!ftp.changeWorkingDirectory(tempPath)) {
						if(!ftp.makeDirectory(tempPath)) {
							return result;
						} else {
							ftp.changeWorkingDirectory(tempPath);
						}
					}
				}
			}
			//设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			if(!ftp.storeFile(filename, input)) {
				return result;
			}
			input.close();
			ftp.logout();
			result = true;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/*
	 * 从ftp服务器下载文件
	 * host FTP服务器hostname
	 * port 端口
	 * username FTP服务器登录账号
	 * password FTP服务器登录密码
	 * remotePath FTP服务器上的相对路径
	 * filename 要下载的文件名
	 * localPath 下载后保存到本地的路径
	 */
	public static boolean downloadFile(String host,int port,
			String username, String password,
			String remotePath,String fileName,
			String localPath) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		int reply;
		try {
			ftp.connect(host, port);
			ftp.login(username, password);
			reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return result;
			}
			ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile ftpFile : fs) {
				if(ftpFile.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ftpFile.getName());
					OutputStream os = new FileOutputStream(localFile);
					ftp.retrieveFile(ftpFile.getName(), os);
					os.close();
				}
			}
			ftp.logout();
			result = true;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
