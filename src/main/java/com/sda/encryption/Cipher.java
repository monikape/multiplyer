package com.sda.encryption;

public interface Cipher {

    String encrypt(String input);

    String decrypt(String input);
}
