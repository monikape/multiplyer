package com.sda.encryption;

public class CaesarCipher implements Cipher {

    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            int next = (c + shift) % Character.MAX_VALUE;
            stringBuilder.append((char) next);
        }

        return stringBuilder.toString();
    }

    @Override
    public String decrypt(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            int next = (c - shift);
            if (next < 0) {
                next = Character.MAX_VALUE + next;
            }
            next %= Character.MAX_VALUE;
            stringBuilder.append((char) next);
        }

        return stringBuilder.toString();
    }
}
