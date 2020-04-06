package resources;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.IOException;

public class ReadWrite
{
	//readWriteText
	public static String readLine(String fileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		br.close();
		return(line);
	}
	
	public static void owriteLine(String fileName, String line) throws IOException
	{
		Writer fw = new FileWriter(fileName);
		fw.write(line);
		fw.close();
	}
	
	//readWriteBin
	public static int[] readBinFile(String fileName) throws IOException
	{
		//var
		int bite;
		int[] bites;
		ArrayList<Integer> alBites = new ArrayList<Integer>();
		InputStream inputStream = new FileInputStream(fileName);
		//read
		while((bite = inputStream.read()) != -1)
		{
			alBites.add(bite);
		}
		bites = new int[alBites.size()];
		for(int i = 0; i < bites.length; i++)
		{
			bites[i] = alBites.get(i);
		}
		//ret
		return(bites);
	}
	public static void writeBinFile(String fileName, int[]bites) throws IOException
	{
		//var
        OutputStream outputStream = new FileOutputStream(fileName);
        //write
        for(int i = 0; i < bites.length; i++)
        {
        	outputStream.write(bites[i]);
        }
	}
}
