package io.hikari.common.test;

import io.hikari.common.util.QRCodeCreator;
import io.hikari.common.util.QRCodeUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
public class QRCodeTest {

    @Test
    public void createQRCode() throws Exception {
        QRCodeCreator.encoder()
                .content("https://io.hikari.org/qr/A84A2C54ECF")
                .size(128, 128)
                .create()
                .toFile("E:/QRCode.png");
    }

    @Test
    public void decodeQRCode() {
        Assert.assertEquals(QRCodeCreator.decodeFromFile("E:/a.png"), "https://io.hikari.org/qr/A84A2C54ECF");
    }

}
