package com.learning.patterns.structural.decorator;

import java.util.Base64;

/**
 * Concrete Decorator: Encryption.
 * Adds encryption behavior before writing and decryption behavior after
 * reading.
 */
public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("EncryptionDecorator: Encrypting data...");
        String encryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        super.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String encryptedData = super.readData();
        System.out.println("EncryptionDecorator: Decrypting data...");
        return new String(Base64.getDecoder().decode(encryptedData));
    }
}
