package me.dimoge.TechnologyHaggis.eventbus;

/**
 * Created by dime on 2015/10/9 0009.
 */
public class FirstEvent {

    private String msg;

    public FirstEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
