package com.example.mqtt_application;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class subscriber implements MqttCallback {

MqttClient client;

public subscriber() {
}

public static void main(String[] args) {
    new subscriber().runSubscriber();
}

public void runSubscriber() {
    try {
        client = new MqttClient("tcp://192.168.0.7:1883", "Vikas");
        client.connect();
        client.setCallback(this);
        client.subscribe("ScorpioHoroscope");
       /* MqttMessage message = new MqttMessage();
        message.setPayload("A single message from my computer fff"
                .getBytes());
        client.publish("foo", message);*/
    } catch (MqttException e) {
        e.printStackTrace();
    }
}

@Override
public void connectionLost(Throwable cause) {
    // TODO Auto-generated method stub

}

@Override
public void messageArrived(String topic, MqttMessage message)
        throws Exception {
 System.out.println(message);   
}

@Override
public void deliveryComplete(IMqttDeliveryToken token) {
    // TODO Auto-generated method stub

}

}
