package com.wan7451.literoute;

/**
 * 拦截器
 *
 * @author wan7451
 */

public interface Interceptor {
    /**
     * 拦截器
     *
     * @param intentWrapper intent包装类，可以对全局intent进行进一步配置
     * @return true 拦截自动执行的intent
     */
    boolean intercept(IntentWrapper intentWrapper);
}
