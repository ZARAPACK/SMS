package com.zero.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

/**
 * Created by ZERO_LIKE on 2020/7/2 3:32
 */
public class SMSUtils {
    static final String accessKeyId = "LTAI4GKBQ2bV5ZXVz47p4cth";
    static final String accessKeySecret = "48USXzDtSUGPIr5naDNMXIhrqYBpJC";

    public static void sendSms(String telephone, String code) throws ClientException {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telephone);
        request.putQueryParameter("SignName", "大鱼数据系统");
        request.putQueryParameter("TemplateCode", "SMS_194920108");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 随机生成4位验证码
     */
    public static String getNumber() {
        int number;//定义两变量
        Random ne = new Random();//实例化一个random的对象ne
        number = ne.nextInt(9999 - 1000 + 1) + 1000;//为变量赋随机值1000-9999
        System.out.println("产生的随机数是:" + number);//输出
        return String.valueOf(number);
    }
}
