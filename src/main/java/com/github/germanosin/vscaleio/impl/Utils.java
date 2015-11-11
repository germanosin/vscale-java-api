package com.github.germanosin.vscaleio.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/**
 * Created by germanosin on 11.11.15.
 */
final class Utils {
    public static Type getSingleParameterUpperBound(ParameterizedType type) {
        Type[] types = type.getActualTypeArguments();
        if (types.length != 1) {
            throw new IllegalArgumentException(
                    "Expected one type argument but got: " + Arrays.toString(types));
        }
        Type paramType = types[0];
        if (paramType instanceof WildcardType) {
            return ((WildcardType) paramType).getUpperBounds()[0];
        }
        return paramType;
    }

    private Utils() {
    }
}
