package com.wirecard.ntltaxi.reportgenerator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.wirecard.ntltaxi.initializer.Initializer;

public class ReportOptimizer extends Initializer{

	@Test
	public static void archivefiles() throws IOException {

		if(isarchive){
			
		
		
		SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH-mm-SS-mmm");
		String data = sf.format(new java.util.Date());

		System.out.println(data);
		File src = new File("C:\\seleniumWorkspace\\DDDTest\\ScreenShot");
		File dest = new File("C:\\seleniumWorkspace\\DDDTest\\archivefolder\\old"+data);

		FileUtils.copyDirectory(src, dest);
		FileUtils.cleanDirectory(src);
		
	isarchive=false;
	
		}
		
	}
		

}
