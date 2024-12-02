package com.github.spring_playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SpelPlayground {
    @Autowired
    private ApplicationContext applicationContext;

    public Object run() throws NoSuchMethodException {
        final StandardEvaluationContext context = new StandardEvaluationContext();
        context.registerFunction("capitalize", StringUtils.class.getDeclaredMethod("capitalize", String.class));
        // context.registerFunction("appendMultipleList", Utils.class.getDeclaredMethod("appendMultipleList", List[].class));

        final ExpressionParser parser = new SpelExpressionParser();
        final String helloReversed = parser.parseExpression("#capitalize('hello')").getValue(context, String.class);
        System.out.println(helloReversed);

        final List<Object> list1 = Arrays.asList("tag1", "tag2", "tag3");
        final List<Object> list2 = Arrays.asList("tag4", "tag5", "tag6");
        final Map<String, Object> variableMap = new HashMap<>(){{
            put("list1", list1);
            put("list2", list2);
        }};
        context.setVariables(variableMap);
        context.setBeanResolver(new BeanFactoryResolver(this.applicationContext));
        return parser.parseExpression("@utils.appendMultipleList(#list1, #list2)").getValue(context, List.class);
    }
}
