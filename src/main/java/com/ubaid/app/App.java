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
		
		
		//archiver
		Archiver archiver = app.getArchiver();

		//get current path
		String path = app.getCurrentDir();

		//get current directory
		File directory = new File(path);
		FileFilter filter = app.new AcceptTGZFile();
		File[] files = directory.listFiles(filter);
		int counter = 0;
		int deletedFile = 0;
		for(int i = 0; i < files.length; i++)
		{
			File archive = files[i];
			System.out.println("\n===> Extracting File: " + archive.getName());

			try
			{
				archiver.extract(archive, directory);
				if(archive.delete())
				{
					System.out.println("\n===> " + ++deletedFile  + "File Deleted: " + archive.getName());
				}

			}
			catch (IOException e)
			{
				System.err.println("\n===> " + ++counter + ": Extraction Error ---- File Not Deleted " + archive.getName());
			}
			
		}		
	}
	
	private String getCurrentDir()
	{
		return System.getProperty("user.dir");
	}
	
	private Archiver getArchiver()
	{
		return ArchiverFactory.createArchiver(ArchiveFormat.TAR, CompressionType.GZIP);
	}
	
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
