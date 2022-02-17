package com.zhi.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: luowenzhi
 * @CreateTime: 10/2/2022
 * 有两种框架的生成方式 barcode4j和google-zxing
 */
public class BarCodeUtils {

    /**
     * 生成字节
     * @param msg
     * @return
     */
    public static byte[] generate(String msg) {
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        generate(msg, ous);
        return ous.toByteArray();
    }

    /**
     * 生成到流
     *
     * @param msg
     * @param ous
     */
    public static void generate(String msg, OutputStream ous) {
        if (StringUtils.isEmpty(msg) || ous == null) {
            return;
        }
        Code39Bean bean = new Code39Bean();
        // 精细度
        final int dpi = 150;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(1.5f / dpi);

        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.setWideFactor(3);
        bean.doQuietZone(false);
        String format = "image/png";
        try {
            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);
            // 生成条形码
            bean.generateBarcode(canvas, msg);
            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成字节
     * @param msg
     * @return
     */
    public static String generateBase64(String msg, int width , int height) {
        byte[] bytes = encodeBarcodeZxing(msg, width, height);
        return "data:image/jpeg;base64,"+ Base64.encodeBase64String(bytes);
    }

    /**
     * 生成条形码
     *
     * @param contents 条形码内容
     * @param width    条形码宽度
     * @param height   条形码高度
     */
    public static byte[] encodeBarcodeZxing(String contents, int width, int height) {
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.CODE_128, width, height, null);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", ous);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ous.toByteArray();
    }
}
