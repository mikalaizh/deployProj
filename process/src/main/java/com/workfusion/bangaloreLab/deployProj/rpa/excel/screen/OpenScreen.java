package com.workfusion.bangaloreLab.deployProj.rpa.excel.screen;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import com.workfusion.rpa.driver.Driver;
import com.workfusion.rpa.helpers.RPA;

public class OpenScreen {
	
	private final Driver driver;
	private final Logger logger;

    public OpenScreen(Logger logger, Driver driver) {
        this.logger=logger;
        this.driver=driver;
    }
    
    public void openNewWorkbook() {
    	RPA.$(By.cssSelector("[CLASS:NetUISimpleButton; NAME:AIOStartDocument; TEXT:Blank workbook]")).click();
    }
    
    public String downloadFileOnNode(String url) {
    	return RPA.downloadFileOnAgent(url);
    }
    
    public void openNewFileAndSwitchTowindow(String filePath, String regWindowTitle) {
    	driver.switchDriver("desktop");
    	RPA.$(By.cssSelector("[CLASS:NetUIRibbonTab; NAME:FileTabButton]")).click();
    	RPA.$(".NetUIRibbonTab[name=\"Open\"]").click();
    	RPA.$(By.cssSelector("[CLASS:NetUISimpleButton; NAME:Browse]")).click();
    	RPA.window("[CLASS:#32770; TITLE:Open]");
    		RPA.$(By.cssSelector("[CLASS:Edit]")).click();
    		RPA.sendKeys(filePath);
			RPA.pressEnter();

			RPA.window("[CLASS:XLMAIN; REGEXPTITLE:" + regWindowTitle +"]");
    }
    



}
