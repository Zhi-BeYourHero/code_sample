package com.zhi.importD.importSelectorDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc:
 */
@Configuration
@Import(MyImportSelector.class)
public class MyConfigure {
}
