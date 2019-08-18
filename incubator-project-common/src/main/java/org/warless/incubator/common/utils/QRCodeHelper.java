package org.warless.incubator.common.utils;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fetaxyu
 * @date 2019-08-06
 */
public class QRCodeHelper {

    // 输出二维码图片格式
    private static final String IMAGE_FORMAT = "PNG";
    // 二维码尺寸
    private static final int DEFAULT_SIZE = 500;

    public static byte[] generateQRCodeImage(String content) {
        try {
            return generateQRCodeImage(content, null);
        } catch (Exception e) {
            throw new RuntimeException("考勤二维码生成失败！");
        }
    }

    public static byte[] generateQRCodeImage(String content, String path) throws Exception {
        Map<EncodeHintType, Object> hintMap = new HashMap<>(3);
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hintMap.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, DEFAULT_SIZE, DEFAULT_SIZE, hintMap);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (StringUtils.isNotBlank(path)) {
            try (OutputStream out = new FileOutputStream(path)) {
                ImageIO.write(image, IMAGE_FORMAT, out);
            }
        }
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(image, IMAGE_FORMAT, out);
            return out.toByteArray();
        }
    }

    public static String decodeQRCode(String filePath) {
        try {
            BufferedImage image = ImageIO.read(new File(filePath));
            BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Map<DecodeHintType, Object> hintMap = new HashMap<>(3);
            hintMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(bitmap, hintMap);
            return result.getText();
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public static byte[] generateWithEncrypt(String content) {
        return generateQRCodeImage(AES.encrypt(content));
    }

    public static String decodeWithDecrypt(String path) {
        String content = decodeQRCode(path);
        return AES.decrypt(content);
    }

}
