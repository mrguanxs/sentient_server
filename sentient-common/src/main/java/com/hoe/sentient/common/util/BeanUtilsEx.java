package com.hoe.sentient.common.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * TODO
 *
 * @Author Gavin
 * @Date 2021/1/28 7:05 下午
 */
public class BeanUtilsEx extends BeanUtils {
    public BeanUtilsEx() {
    }

    public static void copyPropertiesExDecrypt(Object source, Object target, String key, String... ignoreProperties) throws BeansException {
        copyPropertiesEx(source, target, key, (Class)null, ignoreProperties);
    }

    public static void copyPropertiesEx(Object source, Object target, String... ignoreProperties) throws BeansException {
        copyPropertiesEx(source, target, (String)null, (Class)null, ignoreProperties);
    }

    @Nullable
    public static List<PropertyDescriptor> getPropertyDescriptor(Class<?> clazz, String propertyName, Map<String, String> languageFields, Map<String, String> decryptFields) throws BeansException {
        List<PropertyDescriptor> listResult = new ArrayList();
        PropertyDescriptor pid = getPropertyDescriptor(clazz, propertyName);
        if (pid == null) {
            if (languageFields != null && languageFields.size() > 0 && languageFields.containsKey(propertyName)) {
                Locale locale = LocaleContextHolder.getLocale();
                PropertyDescriptor primaryLangPid;
                if (locale.getLanguage() != null && locale.getLanguage().toLowerCase().contains("zh")) {
                    primaryLangPid = getPropertyDescriptor(clazz, (String)languageFields.get(propertyName) + "2");
                    if (primaryLangPid != null) {
                        listResult.add(primaryLangPid);
                    }
                }

                primaryLangPid = getPropertyDescriptor(clazz, (String)languageFields.get(propertyName) + "1");
                if (primaryLangPid != null) {
                    listResult.add(primaryLangPid);
                }
            }

            if (decryptFields != null && decryptFields.size() > 0 && decryptFields.containsKey(propertyName)) {
                PropertyDescriptor primaryLangPid = getPropertyDescriptor(clazz, (String)decryptFields.get(propertyName));
                if (primaryLangPid != null) {
                    listResult.add(primaryLangPid);
                }
            }
        } else {
            listResult.add(pid);
        }

        return listResult;
    }

    private static void copyPropertiesEx(Object source, Object target, String key, Class<?> editable, String... ignoreProperties) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
            }

            actualEditable = editable;
        }

        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = ignoreProperties != null ? Arrays.asList(ignoreProperties) : null;
        PropertyDescriptor[] var7 = targetPds;
        int var8 = targetPds.length;
        Map<String, String> languageFields = new HashMap();
        Map<String, String> decryptFields = new HashMap();
        Field[] fields = getAllFields(target);
        Field[] var13 = fields;
        int var14 = fields.length;


        for(int var9 = 0; var9 < var8; ++var9) {
            PropertyDescriptor targetPd = var7[var9];
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                List<PropertyDescriptor> sourcePdList = getPropertyDescriptor(source.getClass(), targetPd.getName(), languageFields, decryptFields);
                if (sourcePdList != null && sourcePdList.size() > 0) {
                    for(int i = 0; i < sourcePdList.size(); ++i) {
                        PropertyDescriptor sourcePd = (PropertyDescriptor)sourcePdList.get(i);
                        Method readMethod = sourcePd.getReadMethod();
                        if (readMethod == null || !ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                            break;
                        }

                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }

                            Object value = readMethod.invoke(source);
                            if (!objectIsEmpty(value) || sourcePdList.size() == i + 1) {
                                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                    writeMethod.setAccessible(true);
                                }

                                if (!decryptFields.containsKey(targetPd.getName())) {
                                    writeMethod.invoke(target, value);
                                    break;
                                }
                                break;
                            }
                        } catch (Throwable var22) {
                            throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", var22);
                        }
                    }
                }
            }
        }

    }

    private static boolean objectIsEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String) {
            String str = (String)object;
            return StringUtils.isEmpty(str);
        } else {
            return false;
        }
    }

    public static Field[] getAllFields(Object object) {
        Class clazz = object.getClass();

        ArrayList fieldList;
        for(fieldList = new ArrayList(); clazz != null; clazz = clazz.getSuperclass()) {
            fieldList.addAll(new ArrayList(Arrays.asList(clazz.getDeclaredFields())));
        }

        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public static String getLanguageName(String enName, String zhName) {
        Locale locale = LocaleContextHolder.getLocale();
        return locale.getLanguage() != null && locale.getLanguage().toLowerCase().contains("zh") ? zhName : enName;
    }
}

