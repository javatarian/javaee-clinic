/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmatuella.clinic.util;

import com.gmatuella.clinic.entity.Administrator;
import com.gmatuella.clinic.service.AdministratorService;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Guilherme
 */
//Adapted gist from: https://gist.github.com/jtan189/3804290
public class SecurityUtil {

    private static SecurityUtil instance;

    public static synchronized SecurityUtil getInstance() {
        if (instance == null) {
            instance = new SecurityUtil();
        }
        return instance;
    }

    public String createHash(String password) {
        try {
            char[] passwordToChar = password.toCharArray();
            int pbkdf2Iterations = 1000;

            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[24];
            random.nextBytes(salt);

            byte[] hash = pbkdf2(passwordToChar, salt, pbkdf2Iterations, 24);

            return pbkdf2Iterations + ":" + toHex(salt) + ":" + toHex(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException err) {
            err.printStackTrace();
        }
        // format iterations:salt:hash
        return null;
    }

    public boolean validatePassword(String password, String trueHash) {
        try {
            char[] passwordToChar = password.toCharArray();

            // Split the formatted hash
            String[] params = trueHash.split(":");
            int iterations = Integer.parseInt(params[0]);
            byte[] salt = fromHex(params[1]);
            byte[] hash = fromHex(params[2]);

            byte[] testHash = pbkdf2(passwordToChar, salt, iterations, hash.length);
            return slowEquals(hash, testHash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException err) {
            err.printStackTrace();
        }
        return false;
    }

    private byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        return skf.generateSecret(spec).getEncoded();
    }

    //Begin: Utilities.
    //Used on comparison/generation of the hashes and validation.
    //This method prevents an timing attack
    private boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; i++) {
            diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }

    private byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

    private String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }
    //End: Utilities.
}