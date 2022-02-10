package com.zhi.importD.importSelectorDemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc:
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.zhi.dto.StudentDTO"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if ("com.zhi.dto.StudentDTO".equals(s)) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return predicate;
    }
}
