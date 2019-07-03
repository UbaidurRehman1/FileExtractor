package com.ubaid.app;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.rauschig.jarchivelib.ArchiveFormat;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;
import org.rauschig.jarchivelib.CompressionType;

public class App
{
	public static void main(String [] args)
	{
		App app = new App();
		
		
		//create archiver
		Archiver archiver = app.getArchiver();

		//get current path
		String path = app.getCurrentDir();

		//get current directory
		File directory = new File(path);
	
		//get filter
		FileFilter filter = app.new AcceptTGZFile();
		
		//get all files in the current directory
		File[] files = directory.listFiles(filter);

		//counters
		int counter = 0;
		int deletedFile = 0;
		
		//loop which delete each file in this directory
		for(int i = 0; i < files.length; i++)
		{
			//get file
			File archive = files[i];
			System.out.println("\n===> Extracting File: " + archive.getName());

			try
			{
				//extracting it in the current directory
				archiver.extract(archive, directory);
				
				//if no exception occur then delete
				if(archive.delete())
				{
					System.out.println("\n===> " + ++deletedFile  + "File Deleted: " + archive.getName());
				}

			}
			catch (IOException e)
			{
				//on exception, simppy give the message
				System.err.println("\n===> " + ++counter + ": Extraction Error ---- File Not Deleted " + archive.getName());
			}
			
		}		
	}
	
	/**
	 * 
	 * @return current direcotry where jar will place
	 */
	private String getCurrentDir()
	{
		return System.getProperty("user.dir");
	}
	
	/**
	 * 
	 * @return Archiver which is used for extracting .tgz files
	 */
	private Archiver getArchiver()
	{
		return ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
	}
	
	/**
	 * a private class which implements FileFilter 
	 * and it accept only those files which ends with .tgz
	 * @author UbaidurRehman
	 *
	 */
	private class AcceptTGZFile implements FileFilter
	{

		@Override
		public boolean accept(File pathname)
		{
			String fileName = pathname.getName();
			return fileName.endsWith(".tgz");
		}
		
	}
}
