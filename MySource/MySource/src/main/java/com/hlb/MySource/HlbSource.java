package com.hlb.MySource;

import org.apache.flume.Context;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.SimpleEvent;
import org.apache.flume.source.AbstractSource;

import java.util.HashMap;
import java.util.Map;

public class HlbSource extends AbstractSource implements Configurable, PollableSource {

    private String sName;

    @Override
    public Status process() throws EventDeliveryException {
        SimpleEvent event = new SimpleEvent();

        try{
            Map<String,String> headers = new HashMap<String,String>();
            headers.put("k","h");
            event.setBody((sName + " source").getBytes());
            event.setHeaders(headers);
            getChannelProcessor().processEvent(event);
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
            return Status.BACKOFF;
        }
        return Status.READY;
    }

    @Override
    public void configure(Context context) {
        sName = context.getString("sName","flume");
    }

    @Override
    public long getBackOffSleepIncrement() {
        return 0;
    }

    @Override
    public long getMaxBackOffSleepInterval() {
        return 0;
    }
}
