package com.workfusion.bangaloreLab.deployProj.rpa;

import static com.workfusion.rpa.helpers.RPA.driver;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

import com.workfusion.bangaloreLab.deployProj.rpa.excel.screen.OpenScreen;
import com.workfusion.rpa.helpers.RPA;

public class ExcelClient extends RobotDriverWrapper{
	 public static final String EXCEL_FILE_PATH = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE";

	    public ExcelClient(Logger logger) {
	        super(logger);
	        initDriver();
	    }

	    private void initDriver() {
	        RPA.timeouts(15 * 1000);
	    }

	    public OpenScreen openApplication() {
	    	RPA.open(EXCEL_FILE_PATH);
	    	RPA.window("[CLASS:XLMAIN; TITLE:Excel]");
	        return new OpenScreen(logger, driver());
	    }
	    
	    
}
