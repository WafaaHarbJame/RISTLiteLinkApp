package com.ristlitelink.ristlitelink.classes;
public class MessageEvent {

    public static final String TYPE_requestType = "requestType";



    //    public int PagerPosition;
    public Object data;
    public String type;

    public MessageEvent(String type, Object msgData) {
        this.data = msgData;
        this.type = type;
    }



    public MessageEvent(String type) {
        this.type = type;
    }

    public MessageEvent() {
    }

}

