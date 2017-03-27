package com.wan7451.literoute;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * LiteRouter for Android
 *
 * @author wan7451
 * @data 2017/3/24
 */

public final class LiteRouter {

    private Interceptor interceptor;

    private LiteRouter(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    private LiteRouter(){}
    /**
     * create router class service
     *
     * @param service router class
     * @param context from context
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> service, final Context context) {

        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object... args)
                            throws Throwable {
                        //根据方法参数生成IntentWrapper
                        IntentWrapper intentWrapper = loadIntentWrapper(context, method, args);
                        //获得方法的返回值类型
                        Class returnTYpe = method.getReturnType();
                        //是否拦截
                        boolean isIntercept = interceptor.intercept(intentWrapper);
                        //无返回值 直接启动
                        if (returnTYpe == void.class) {
                            if (interceptor == null || !isIntercept) {
                                intentWrapper.start();
                            }
                            return null;
                        } else if (returnTYpe == IntentWrapper.class) {
                            return intentWrapper;
                        }
                        throw new RuntimeException("method return type only support 'void' or 'IntentWrapper'");
                    }
                });
    }

    private IntentWrapper loadIntentWrapper(Context context, Method method, Object... args) {
        return new IntentWrapper.Builder(context, method, args).build();
    }

    public static LiteRouter createRouter(){
        return new LiteRouter();
    }

    public static final class Builder {
        private Interceptor interceptor;

        public Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        public LiteRouter build() {
            return new LiteRouter(interceptor);
        }
    }
}
