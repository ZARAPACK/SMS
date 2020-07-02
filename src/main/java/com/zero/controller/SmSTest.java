package com.zero.controller;

import com.aliyuncs.exceptions.ClientException;
import com.zero.utils.SMSUtils;

/**
 * Created by ZERO_LIKE on 2020/7/2 19:03
 */
public class SmSTest {
    public static void main(String[] args) throws ClientException {
        String number = SMSUtils.getNumber();
        SMSUtils.sendSms("15814530073",number);
    }
}
