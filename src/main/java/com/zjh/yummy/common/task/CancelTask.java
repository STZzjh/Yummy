package com.zjh.yummy.common.task;

import com.zjh.yummy.common.db.SimpleQuery;
import com.zjh.yummy.entity.OrderGoods;
import com.zjh.yummy.entity.OrderTime;
import com.zjh.yummy.service.DictService;
import com.zjh.yummy.service.OrderGoodsService;
import com.zjh.yummy.service.OrderTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class CancelTask {

    @Autowired
    private OrderGoodsService orderGoodsService;
    @Autowired
    private DictService dictService;
    @Autowired
    private OrderTimeService orderTimeService;

    public CancelTask() {
        System.out.println("init");
    }

    @Scheduled(cron = "0 0/1 * * * ? ") // 每分钟执行
    public void taskCycle() {
        SimpleQuery query = new SimpleQuery();
        query.and("status=", "1");
        List<OrderGoods> list = orderGoodsService.findList(query);
        HashMap<String, String> setting = dictService.getSetting();
        for (OrderGoods orderGoods : list) {
            Date createTime = orderGoods.getCreateTime();
            long time = System.currentTimeMillis() -  createTime.getTime();
            String autoCancel = setting.get("AutoCancel");
            int i = Integer.parseInt(autoCancel);
            long fenzhong = time / 1000 / 60;
            if (fenzhong >= i) {
                OrderTime orderTime = new OrderTime();
                orderTime.setCreateTime(new Date());
                orderTime.setStatus("7");
                orderTime.setOrderNo(orderGoods.getOrderNo());
                orderTime.setStatusTime(new Date());
                orderTimeService.insert(orderTime);
            }
        }
        System.out.println("使用SpringMVC框架配置定时任务");
    }

}
