package org.example.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ymm
 * @date: 2022/8/11
 * @version: 1.0.0
 * @description:
 */
public class DateConverter implements Converter<String, Date> {

    /**
     * 把字符串转换为日期对象
     *
     * @param s 表单传递的请求参数2022-2-2
     * @return
     */
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
