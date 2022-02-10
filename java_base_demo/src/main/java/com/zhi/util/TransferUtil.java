package com.zhi.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: luowenzhi
 * @CreateTime: 9/2/2022
 * @desc:
 */
public class TransferUtil {

    public static <S, T> List<T> transfer(Collection<S> sourceCollection, Function<S, T> function) {
        if (sourceCollection == null || sourceCollection.isEmpty()) {
            return Collections.emptyList();
        }
        return sourceCollection.stream().map(function).collect(Collectors.toList());
    }
}