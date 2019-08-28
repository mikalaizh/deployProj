package com.workfusion.bangaloreLab.deployProj.supplier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.workfusion.bangaloreLab.deployProj.rpa.ExcelClient;
import com.workfusion.bangaloreLab.deployProj.rpa.excel.screen.OpenScreen;
import com.workfusion.intake.api.connector.TransactionSupplier;
import com.workfusion.intake.api.domain.Transaction;
import com.workfusion.rpa.core.security.SecurityUtils;

public class ExcelExample implements TransactionSupplier{

	private final SecurityUtils securityUtils;
    private final Logger logger;
    private String excelPath = "https://rpa-grid.s3.amazonaws.com/integration-test/resource/ExcelTemplate.xlsx";
    
    @Inject
    public ExcelExample(final SecurityUtils securityUtils, final Logger logger) {
        this.logger = logger;
        this.securityUtils = securityUtils;
    }

    @Override
    public Collection<Transaction> get() {
        Collection<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setId(uuid());
        
        ExcelClient excel = new ExcelClient(logger);
        OpenScreen openScreen = excel.openApplication();
        openScreen.openNewWorkbook();
        
        openScreen.openNewFileAndSwitchTowindow(openScreen.downloadFileOnNode(excelPath),"data.+");
        
        transactions.add(transaction);

        return transactions;
    }
    
    private String uuid() {
        return UUID.randomUUID().toString();
    }
    
}
