package com.zhi.spi;

import com.zhi.IsAssignableFromDemo.ParamDefaultValue;
import lombok.Builder;
import lombok.Data;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: luowenzhi
 * @CreateTime: 6/2/2022
 * @desc:
 */
public class Application {
    public static void main(String[] args) throws IOException {
        Reflections reflections = new Reflections("com.zhi.IsAssignableFromDemo");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(ParamDefaultValue.class);
        System.out.println(typesAnnotatedWith);
//        testComparator();
    }



    @Builder
    @Data
    public static class Version {
        private Integer maxVersion;
        private Integer subVersion;
    }

    private static void testComparator() {
        Version v1 = Version.builder().maxVersion(1).subVersion(1).build();
        Version v2 = Version.builder().maxVersion(1).subVersion(2).build();
        Version v3 = Version.builder().maxVersion(2).subVersion(1).build();
        List<Version> versionList = Arrays.asList(v1, v2, v3);
        List<Version> versions = versionList.stream().sorted(
                Comparator.comparing(Version::getMaxVersion).reversed()
                        .thenComparing(Version::getSubVersion)
        ).collect(Collectors.toList());
        System.out.println(versions);
    }
}
