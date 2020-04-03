package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetToken implements Serializable {

    /**
     * userID : sample string 1
     * password : sample string 2
     * deviceID : sample string 3
     * mac : sample string 4
     * gps : sample string 5
     * phoneType : sample string 6
     * ip : sample string 7
     * resolvingPower : sample string 8
     */

    private String userID;
    private String password;
    private String deviceID;
    private String mac;
    private String gps;
    private String phoneType;
    private String ip;
    private String resolvingPower;

}