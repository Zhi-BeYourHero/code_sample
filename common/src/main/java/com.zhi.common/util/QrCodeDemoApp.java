package com.zhi.common.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: luowenzhi
 * @CreateTime: 11/2/2022
 * @desc:
 */
public class QrCodeDemoApp {
    public static void main(String[] args) throws FileNotFoundException {
        String str = "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\"/>\n" +
                "  <meta name=\"viewport\" content=\"width=device-width\"/>\n" +
                "  <title>Files...</title>\n" +
                "  <link rel=\"stylesheet\" href=\"/_theme/css/fancyindex.css\">\n" +
                "  <script>\n" +
                "    window.document.title = window.location.pathname;\n" +
                "  </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"box box-breadcrumbs\">\n" +
                "    <div class=\"box-header\">\n" +
                "      <div class=\"box-header-content\">\n" +
                "        <div id=\"breadcrumbs\" class=\"breadcrumbs\">\n" +
                "          <a href=\"#\"></a>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"box-content clearfix\">\n" +
                "      <h1>Index of:\n" +
                "/dwbuild/mobile/android/SaasAppPlus/app-plus_1.0.0_feature_yh/20220104-16-r6ee734049e067e2d2d2529592ef7161799bce2fa/</h1>\n" +
                "<table id=\"list\"><thead><tr><th style=\"width:55%\"><a href=\"?C=N&amp;O=A\">File Name</a>&nbsp;<a href=\"?C=N&amp;O=D\">&nbsp;&darr;&nbsp;</a></th><th style=\"width:20%\"><a href=\"?C=S&amp;O=A\">File Size</a>&nbsp;<a href=\"?C=S&amp;O=D\">&nbsp;&darr;&nbsp;</a></th><th style=\"width:25%\"><a href=\"?C=M&amp;O=A\">Date</a>&nbsp;<a href=\"?C=M&amp;O=D\">&nbsp;&darr;&nbsp;</a></th></tr></thead>\n" +
                "<tbody><tr><td class=\"link\"><a href=\"../\">Parent directory/</a></td><td class=\"size\">-</td><td class=\"date\">-</td></tr>\n" +
                "<tr><td class=\"link\"><a href=\"proguard/\" title=\"proguard\">proguard/</a></td><td class=\"size\">-</td><td class=\"date\">2022-01-04 18:23</td></tr>\n" +
                "<tr><td class=\"link\"><a href=\"AppPlus-appA-release-16.aab\" title=\"AppPlus-appA-release-16.aab\">AppPlus-appA-release-16.aab</a></td><td class=\"size\">28.4 MiB</td><td class=\"date\">2022-01-04 18:23</td></tr>\n" +
                "<tr><td class=\"link\"><a href=\"AppPlus-appA-release-16.apk\" title=\"AppPlus-appA-release-16.apk\">AppPlus-appA-release-16.apk</a></td><td class=\"size\">26.9 MiB</td><td class=\"date\">2022-01-04 18:23</td></tr>\n" +
                "</tbody></table>\n" +
                "</div>\n" +
                "</div>\n" +
                "<script>\n" +
                "  var loc = window.location.pathname;\n" +
                "  var segments = loc.split('/');\n" +
                "  var breadcrumbs = '';\n" +
                "  var currentPath = '/';\n" +
                "  for (var i=0; i<segments.length; i++) {\n" +
                "    if (segments[i] !== '') {\n" +
                "      currentPath += segments[i] + '/';\n" +
                "      breadcrumbs += '<a href=\"' +  currentPath + '\">' + window.unescape(segments[i]) + '<\\/a>';\n" +
                "    } else if (segments.length -1 !== i) {\n" +
                "      currentPath += '';\n" +
                "      breadcrumbs += '<a href=\"' + currentPath + '\">Root<\\/a>';\n" +
                "    }\n" +
                "  }\n" +
                "  document.getElementById('breadcrumbs').innerHTML = breadcrumbs;\n" +
                "</script>\n" +
                "<script src=\"/_theme/js/history.js\"></script>\n" +
                "<p>如遇问题，请联系构建服务热线</p>\n" +
                "</body>\n" +
                "</html>";
        Pattern ANDROID_RESOLVE_PATTERN_PATTERN = Pattern.compile("(?!href).*href=([\"'])(.*?.apk)\\1.*");
        Matcher matcher = ANDROID_RESOLVE_PATTERN_PATTERN.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        };
    }
}
