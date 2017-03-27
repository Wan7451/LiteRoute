# LiteRoute

Android 轻量级路由

主要用与解决： 多模块开发中 界面跳转的问题，降低模块之间的耦合性



## 使用
### 1. 创建接口


使用方式与Retrofit类似
* @ClassName  指定要跳转组件类
* @RequestCode  Activity跳转的Request,Service设置无效
* @Key       Intent传值 值的key
* 返回值  只能 null  或者  IntentWrapper

```
public interface IntentService {

   @ClassName("com.wan7451.literoute.sample.Main2Activity")
    @RequestCode(100)
    void startMain2Activity(@Key("param1") String param1, @Key("param2") int param2);

    @ClassName("com.wan7451.literoute.sample.Main2Activity")
    IntentWrapper startMain2ActivityRaw(@Key("param1") String param1, @Key("param2") int param2);

}
```

### 2. 初始化LiteRoute

```
//创建LiteRouter
LiteRouter liteRouter = LiteRouter.createRouter();
//创建接口实现类对象
IntentService intentService = liteRouter.create(IntentService.class, this);

```

### 3. 执行跳转

```
//调用方法，进行跳转
intentService.startMain2Activity("android", 2016);
```

### 4. 其他用法

```
IntentWrapper intentWrapper = intentService.startMain2ActivityRaw("android", 2016);
// intent
Intent intent = intentWrapper.getIntent();
// add your flags
intentWrapper.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
// start
intentWrapper.start();
```

### 添加依赖

```
compile 'com.wan7451:literouter:1.0.0'
```


### 主要技术：
1. Java注解
2. 动态代理


文章
http://www.wan7451.cn/2017/03/24/LiteRouter-%E8%BD%BB%E9%87%8F%E7%BA%A7%E8%B7%AF%E7%94%B1/

