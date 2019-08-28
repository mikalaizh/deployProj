package com.workfusion.bangaloreLab.deployProj.app;

import com.workfusion.intake.core.Module;

import org.codejargon.feather.Provides;

import javax.inject.Named;

public class ModuleExample implements Module {

    @Provides
    @Named("defaultS3Bucket")
    public String s3Bucket() {
        return "doc-upload";
    }

}
