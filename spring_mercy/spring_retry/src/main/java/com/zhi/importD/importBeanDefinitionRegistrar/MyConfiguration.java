package com.zhi.importD.importBeanDefinitionRegistrar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc:
 */
@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
public class MyConfiguration {
}
