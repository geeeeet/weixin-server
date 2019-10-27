package pers.lrf.weixinserver.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * desc
 */
@Slf4j
@Component
public class BeanUtil implements ApplicationContextAware {

    private static WebApplicationContext context;

    public static Object getCustomProperty(String field, Object obj) {
        Object o;
        if (field.contains(".")) {
            String parent = field.substring(0, field.indexOf("."));
            String child = field.substring(field.indexOf(".") + 1);
            field = child;
            obj = getPropertyValue(parent, obj);
        }
        o = getPropertyValue(field, obj);
        return o;
    }

    public static Object getPropertyValue(String field, Object obj) {
        Object o = null;
        try {
            PropertyDescriptor pd = new PropertyDescriptor(field,
                    obj.getClass());//获取属性声明
            Method getMethod = pd.getReadMethod();//获得get方法
            o = getMethod.invoke(obj);//反射调用
        } catch (Exception e) {
            log.error(">>>>>>>>>>>>>>getPropertyValue failed.", e);
        }
        return o;
    }


    /**
     * @param beanName
     * @return Object
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = (WebApplicationContext) applicationContext;
    }
}
