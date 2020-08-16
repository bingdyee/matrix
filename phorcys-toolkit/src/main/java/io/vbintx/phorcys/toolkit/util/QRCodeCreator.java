package io.vbintx.phorcys.toolkit.util;

import com.google.common.base.Strings;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import io.vbintx.phorcys.toolkit.exception.CreateQRCodeFailedException;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
public class QRCodeCreator {

    private static final int DEFAULT_SIZE = 500;
    private static final String PNG = "PNG";
    private static final MatrixToImageConfig MATRIX_TO_IMAGE_CONFIG = new MatrixToImageConfig();

    private int width;
    private int height;
    private String content;
    private BitMatrix bitMatrix;

    public QRCodeCreator() {
        this.height = DEFAULT_SIZE;
        this.width = DEFAULT_SIZE;
    }

    public static QRCodeCreator encoder() {
        return new QRCodeCreator();
    }

    public static String decodeFromFile(String path) {
        return QRCodeUtil.decode(path);
    }

    public static String decodeFromStream(InputStream stream) {
        return QRCodeUtil.decode(stream);
    }

    public QRCodeCreator content(String content) {
        this.content = content;
        return this;
    }

    public QRCodeCreator size(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public QRCodeCreator create() {
        if (Strings.isNullOrEmpty(content)) {
            throw new CreateQRCodeFailedException("QRCode content is null!");
        }
        try {
            this.bitMatrix = QRCodeUtil.encode(content, width, height);
        } catch (Exception e) {
            throw new CreateQRCodeFailedException();
        }
        return this;
    }

    public BufferedImage getImage() {
        checkHasCreated();
        return MatrixToImageWriter.toBufferedImage(bitMatrix, MATRIX_TO_IMAGE_CONFIG);
    }

    public void toFile(String path) {
        checkHasCreated();
        try  {
            MatrixToImageWriter.writeToPath(bitMatrix, PNG, new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toStream(OutputStream out) {
        checkHasCreated();
        try {
            MatrixToImageWriter.writeToStream(bitMatrix, PNG, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkHasCreated() {
        if (Objects.isNull(bitMatrix)) {
            throw new CreateQRCodeFailedException("QRCode has not yet been created!");
        }
    }

}
