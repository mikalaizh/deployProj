package com.workfusion.bangaloreLab.deployProj.app;

import com.workfusion.intake.core.Module;
import com.workfusion.bangaloreLab.deployProj.utils.Cipher;
import com.workfusion.bangaloreLab.deployProj.utils.InMemoryBase64Encoder;

import org.codejargon.feather.Provides;

public class CipherModule implements Module {

    @Provides
    public Cipher cipher(InMemoryBase64Encoder inMemoryBase64Encoder) {
        return inMemoryBase64Encoder;
    }

}
