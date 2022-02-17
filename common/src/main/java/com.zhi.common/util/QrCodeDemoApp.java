package com.zhi.common.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.io.*;

/**
 * @Author: luowenzhi
 * @CreateTime: 11/2/2022
 * @desc:
 */
public class QrCodeDemoApp {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("xiaozhi.png");
        QrCodeUtil.generate("🐮🍺", QrConfig.create(), file);
    }
}
