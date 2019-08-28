package com.workfusion.bangaloreLab.deployProj.utils;

public interface Cipher {

    byte[] encode(byte[] content);

    byte[] decode(byte[] content);

}
