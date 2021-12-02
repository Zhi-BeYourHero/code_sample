package com.zhi.reflectAnnotation;

/**
 * 假设银行提供了一些 API 接口，对参数的序列化有点特殊，不使用 JSON，而是需要我们把参数依次拼在一起构成一个大字符串。
 * 按照银行提供的 API 文档的顺序，把所有参数构成定长的数据，然后拼接在一起作为整个字符串。
 * 因为每一种参数都有固定长度，未达到长度时需要做填充处理：
 * 字符串类型的参数不满长度部分需要以下划线右填充，也就是字符串内容靠左；
 * 数字类型的参数不满长度部分以 0 左填充，也就是实际数字靠右；
 * 货币类型的表示需要把金额向下舍入 2 位到分，以分为单位，作为数字类型同样进行左填充。
 * 对所有参数做 MD5 操作作为签名（为了方便理解，Demo 中不涉及加盐处理）。
 */
public class Application {

}
