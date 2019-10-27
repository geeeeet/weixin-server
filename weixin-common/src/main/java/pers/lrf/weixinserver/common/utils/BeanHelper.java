package pers.lrf.weixinserver.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangxf
 * @date 2018/7/11 10:44
 * @email zhangxiaofei@able-elec.com
 */
public class BeanHelper {

    /**
     * 单个类型转换
     *
     * @param source
     * @param clazz
     * @return
     * @author zhangys
     * @date 2016年4月13日 下午4:04:33
     */
    public static final <T> T transTo(Object source, Class<T> clazz) {
        Assert.notNull(clazz, "转换目标对象类型参数不能为空!");
        Assert.state(!ClassUtils.isPrimitiveOrWrapper(clazz), "不支持基本(原始)类型转换!");
        if (source == null) return null;
        T target = BeanUtils.instantiateClass(clazz);
        copyProperties(source, target);
        return target;
    }

    /**
     * 属性拷贝
     *
     * @param source
     * @param target
     * @author zhangys
     * @date 2016年4月13日 下午4:04:41
     */
    public static <S, T> void copyProperties(S source, T target) {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 批量类型转换
     *
     * @param colls
     * @param clazz
     * @return
     * @author zhangys
     * @date 2016年4月13日 下午4:04:48
     */
    public static final <T> List<T> batchTransTo(Collection<?> colls, Class<T> clazz) {
        Assert.notNull(clazz, "转换目标对象类型参数不能为空!");
        if (CollectionUtils.isEmpty(colls)) return null;
        List<T> target = new ArrayList<T>();
        Iterator<?> iter = colls.iterator();
        while (iter.hasNext()) {
            T t = transTo(iter.next(), clazz);
            if (t != null) target.add(t);
        }
        return target;
    }

}
