package com.zhi.importDemo;

import com.zhi.dto.StudentDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc:
 */
@Configuration
@Import(StudentDTO.class)
public class MyConfigure {
}