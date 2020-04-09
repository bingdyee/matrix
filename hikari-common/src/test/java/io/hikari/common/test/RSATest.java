package io.hikari.common.test;

import io.hikari.common.security.Base64RSA;
import io.hikari.common.security.PemRSA;
import io.hikari.common.security.RSA;
import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

/**
 * @author Noa Swartz
 * @date 2020-04-09
 */
public class RSATest {

    private static final String MSG = "Hello World";

    public static final String PRIVATE_KEY_FILE = "E:\\rsa_files\\id_rsa";
    public static final String PUBLIC_KEY_FILE = "E:\\rsa_files\\id_rsa.pub";

    @Test
    public void testBase64RSA() {
        Base64RSA rsa = new Base64RSA();
        if (rsa.initRandomKeys()) {
            doTest(rsa);
        }
    }

    @Test
    public void testRSAWriter() {
        RSA rsa = new PemRSA();
        rsa.initRandomKeys();
        rsa.exportPrivateKey(PRIVATE_KEY_FILE);
        rsa.exportPublicKey(PUBLIC_KEY_FILE);
    }

    @Test
    public void testRSAReader() {
        RSA rsa = new PemRSA();
        rsa.initRandomKeys();
        rsa.loadPrivateKey(PRIVATE_KEY_FILE);
        rsa.loadPublicKey(PUBLIC_KEY_FILE);
        doTest(rsa);
    }

    private void doTest(RSA rsa) {
        byte[] cipherBytes = rsa.encrypt(MSG.getBytes(), rsa.getPrivateKey());
        String cipherText =  Base64.getEncoder().encodeToString(cipherBytes);
        Assert.assertNotNull(cipherText);
        Assert.assertTrue(rsa.verify(cipherBytes, rsa.sign(cipherBytes)));
        String plainText = new String(rsa.decrypt(Base64.getDecoder().decode(cipherText.getBytes()), rsa.getPublicKey()));
        Assert.assertEquals(plainText, MSG);
    }

}
