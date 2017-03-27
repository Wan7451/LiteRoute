package com.wan7451.literoute.sample;

import com.wan7451.literoute.IntentWrapper;
import com.wan7451.literoute.annotations.ClassName;
import com.wan7451.literoute.annotations.Key;
import com.wan7451.literoute.annotations.RequestCode;

/**
 * Created by wanggang on 2017/3/24.
 */

public interface IntentService {

    @ClassName("com.wan7451.literoute.sample.Main2Activity")
    @RequestCode(100)
    void startMain2Activity(@Key("param1") String param1, @Key("param2") int param2);

    @ClassName("com.wan7451.literoute.sample.Main2Activity")
    IntentWrapper startMain2ActivityRaw(@Key("param1") String param1, @Key("param2") int param2);

}
