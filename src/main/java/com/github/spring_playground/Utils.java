package com.github.spring_playground;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("utils")
public class Utils {

    public List<Object> appendMultipleList(final List<Object>... lists) {
        final List<Object> result = new ArrayList<>();
        for (final List<Object> list : lists) {
            if (CollectionUtils.isEmpty(list)) {
                continue;
            }
            result.addAll(list);
        }
        return result;
    }
}
