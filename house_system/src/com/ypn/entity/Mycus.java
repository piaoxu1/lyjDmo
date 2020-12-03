package com.ypn.entity;

import com.ypn.dao.BaseDao;


/**
 * @author ypn
 * @date 2020/8/21
 * @motto I raise pigs in your field
 * @desc   客户信息实体类
 */
public class Mycus extends BaseDto {
    private Long cId;
    private String cName;
    private  String cSex;
    private  String cTel;
    private String cTel1;
    private  String cCard;
   public  Mycus(){

   }


    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public String getcTel1() {
        return cTel1;
    }

    public void setcTel1(String cTel1) {
        this.cTel1 = cTel1;
    }

    public String getcCard() {
        return cCard;
    }

    public void setcCard(String cCard) {
        this.cCard = cCard;
    }

    public Mycus(Long cId, String cName, String cSex, String cTel, String cTel1, String cCard) {
        this.cId = cId;
        this.cName = cName;
        this.cSex = cSex;
        this.cTel = cTel;
        this.cTel1 = cTel1;
        this.cCard = cCard;
    }

    @Override
    public String toString() {
        return "Mycus{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cSex='" + cSex + '\'' +
                ", cTel='" + cTel + '\'' +
                ", cTel1='" + cTel1 + '\'' +
                ", cCard='" + cCard + '\'' +
                ", AllCount=" + AllCount +
                ", AllPage=" + AllPage +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                '}';
    }
}
