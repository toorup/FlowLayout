package com.icecool.mylist_xj;

public class info_xianji {


    private String txt;
    private boolean checkState=false;
    private String playUrl;


    public info_xianji() {
        super();
    }


    public info_xianji(String txt) {
        super();
        this.txt = txt;
    }
    public info_xianji(String txt, String playUrl) {
        super();
        this.txt = txt;
        this.playUrl=playUrl;
    }


    public String gettxt() {
        return txt;
    }
    public String getPlayUrl(){return playUrl;}

    public void setcheckState(boolean checkState) {
        this.checkState=checkState;
    }

    public boolean getcheckState() {
        return checkState;
    }

    public void settxt(String txt) {
        this.txt = txt;
    }
    public void setPlayUrl(String  playUrl){this.playUrl=playUrl;}


    @Override
    public String toString() {
        return "info [txt=" + txt + "]";
    }

}