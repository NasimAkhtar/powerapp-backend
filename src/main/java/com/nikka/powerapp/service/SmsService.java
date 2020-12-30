package com.nikka.powerapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

import com.nikka.powerapp.dao.model.Complain;


@Service
public class SmsService {

    @Async
    public void sendSMS(Complain complain) {
        Map<String, MessageAttributeValue> smsAttributes =
                new HashMap<String, MessageAttributeValue>();
        smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                .withStringValue("Transactional")
                .withDataType("String"));


        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(
                "",
                "");

        AmazonSNS snsClient = AmazonSNSClientBuilder
                .standard()
                .withRegion("ap-south-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();


        String message = buildMessage(complain);
        String phoneNumber = "+91"+complain.getMobile();
        sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);
    }

    private String buildMessage(Complain complain) {
        StringBuilder message = new StringBuilder();
        message.append("Dear")
                .append(" ")
                .append(complain.getName())
                .append(" ")
                .append("Your complain has been registered for Battery/Inverter Service.")
                .append(" ")
                .append("- Real Power")
                .append(" ")
                .append("Call Us @ +919793497324");
        return message.toString();
    }

    public void sendSMSMessage(AmazonSNS snsClient, String message,
                                      String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {

        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(smsAttributes));

    }
}
