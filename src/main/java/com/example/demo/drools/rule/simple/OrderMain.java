package com.example.demo.drools.rule.simple;

import com.example.demo.drools.bean.Order;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * https://blog.csdn.net/weixin_41988224/article/details/107532973
 */
public class OrderMain {
    public static void main(String[] args) {
        //获取KieServices
        KieServices kieServices = KieServices.Factory.get();
        //获取KieContainer对象
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //从Kie容器对象中获取会话对象，用于和规则引擎交互
        KieSession kieSession = kieContainer.newKieSession();

        //Fact对象，事实对象
        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
        Order order = new Order();
        order.setOriginalPrice(210D); //double类型

        //将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
        kieSession.insert(order);
        //激活规则引擎，由Drools框架自动进行规则匹配，如果规则匹配成功则执行规则
        kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();

        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
                "，优惠后价格：" + order.getRealPrice());
    }
}
