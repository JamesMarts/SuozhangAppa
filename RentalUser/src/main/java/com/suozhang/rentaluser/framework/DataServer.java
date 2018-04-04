package com.suozhang.rentaluser.framework;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.BillingCycleBo;
import com.suozhang.rentaluser.entity.bo.BillingDetailBo;
import com.suozhang.rentaluser.entity.bo.LifeMenuBo;
import com.suozhang.rentaluser.entity.bo.LifeMenuSection;
import com.suozhang.rentaluser.entity.bo.PayTypeBo;
import com.suozhang.rentaluser.entity.bo.RepairServiceBo;
import com.suozhang.rentaluser.entity.bo.RoomConfigBo;
import com.suozhang.rentaluser.entity.enums.LifeMenu;
import com.suozhang.rentaluser.entity.enums.PayType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/7 16:41
 */
public class DataServer {



    public static List<BaseBo> getReportData() {
        List<BaseBo> imageArrayBos = new ArrayList<>();

        imageArrayBos.add(new BaseBo("房子不存在或已交易"));
        imageArrayBos.add(new BaseBo("房源信息与描述不符"));
        imageArrayBos.add(new BaseBo("虚假房源"));
        imageArrayBos.add(new BaseBo("房东信息虚假"));
        imageArrayBos.add(new BaseBo("其他"));

        return imageArrayBos;
    }

    public static List<LifeMenuSection> getSampleData() {
        List<LifeMenuSection> list = new ArrayList<>();
        list.add(new LifeMenuSection(true, "租约", false));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_myroom, "我的房间", LifeMenu.MYROOM.value())));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_contract, "我的合同", LifeMenu.CONTRACT.value())));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_payment_records, "缴费记录", LifeMenu.PAYMENT_RECORDS.value())));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_repair, "报修服务", LifeMenu.REPAIF.value())));
        list.add(new LifeMenuSection(true, "服务", false));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_move, "搬家", LifeMenu.MOVE.value())));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_fitment, "装修", LifeMenu.FITMENT.value())));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_clean, "家政保洁", LifeMenu.CLEAN.value())));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_wash, "洗衣", LifeMenu.WASH.value())));
        list.add(new LifeMenuSection(new LifeMenuBo(R.drawable.ic_life_menu_maintenance, "家电维修", LifeMenu.MAINTENANCE.value())));
        return list;
    }



    public static List<PayTypeBo> getPayType() {
        List<PayTypeBo> list = new ArrayList<>();
        list.add(new PayTypeBo("支付宝", R.drawable.ic_pay_alipay, PayType.AliPay.value()));
        list.add(new PayTypeBo("微信", R.drawable.ic_pay_wx, PayType.WeiXin.value()));
        list.add(new PayTypeBo("银行卡", R.drawable.ic_pay_card, PayType.BankCard.value()));

        return list;
    }

    public static List<MultiItemEntity> getRecoedsData() {
        ArrayList<MultiItemEntity> list = new ArrayList<>();
        ArrayList<BillingCycleBo> cycleBos = new ArrayList<>();
        ArrayList<BillingDetailBo> detailBos1 = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1; j++) {
                detailBos1.add(j, new BillingDetailBo("实木家具" + i, 200));
            }
            cycleBos.add(i, new BillingCycleBo("2017.09.01", "2017.09.01", "2017.09.01", detailBos1));
        }
        Logger.d(cycleBos);

        for (int i = 0; i < cycleBos.size(); i++) {
            BillingCycleBo shareKeyBo = cycleBos.get(i);
            for (int j = 0; j < shareKeyBo.getBillingDetailBos().size(); j++) {
                BillingDetailBo commonChildBo = shareKeyBo.getBillingDetailBos().get(j);
                shareKeyBo.addSubItem(commonChildBo);
            }
            list.add(shareKeyBo);
        }
        return list;

    }

    public static List<RepairServiceBo> getRepairList() {
        List<RepairServiceBo> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i, new RepairServiceBo("2017.08.01", i, "马桶坏了，臭水流了满屋子，连拖鞋里面都死污水，请tfboys马上来解决"));
        }

        return list;
    }


    public static List<RoomConfigBo> getConfigImage() {

        List<RoomConfigBo> roomConfigBo = new ArrayList<>();

        String jsonStr = "[{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/stove@2x.png\",\"id\":\"06607a43-1d5b-4982-827f-41ed911687bf\",\"name\":\"燃气灶\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/washer@2x.png\",\"id\":\"a79ceae3-139c-48e7-9c0d-34d7035e18e1\",\"name\":\"洗衣机\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/waterheater@2x.png\",\"id\":\"d2829a1d-ddfb-4514-8525-bbeeba21ea82\",\"name\":\"热水器\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/pansonic@2x.png\",\"id\":\"1adeb14a-e25d-466d-8220-b6fec4722db1\",\"name\":\"微波炉\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/wifi@2x.png\",\"id\":\"d7a1095b-81ef-4a39-9596-44920445f17a\",\"name\":\"WIFI\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/doublebed@2x.png\",\"id\":\"f7d9091b-cefe-47bb-9290-6370ace63520\",\"name\":\"床\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/refrigerator@2x.png\",\"id\":\"536008c5-4448-40f9-aa01-a41850849863\",\"name\":\"冰箱\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/closet@2x.png\",\"id\":\"4ae9b0c2-d4d1-425a-b8b5-b739f921827c\",\"name\":\"衣柜\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/airconditioner@2x.png\",\"id\":\"4d99fbb8-142a-4d8d-abcf-48ffce27b960\",\"name\":\"空调\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/TV@2x.png\",\"id\":\"01be0bc7-3d98-436b-a70a-1325009fce72\",\"name\":\"电视机\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null},{\"configId\":null,\"roomId\":null,\"isDic\":true,\"icon\":\"http://10.10.2.99:5555/Content/themes/appIcons/sofa@2x.png\",\"id\":\"ef794466-db28-428b-ad0b-d3513d2a57f1\",\"name\":\"沙发\",\"createTime\":\"2017-12-18 14:31:37\",\"version\":null}]";

        roomConfigBo = JSON.parseArray(jsonStr, RoomConfigBo.class);
        return roomConfigBo;
    }

    public static List<BaseBo> getDateData() {
        List<BaseBo> imageArrayBos = new ArrayList<>();
        imageArrayBos.add(new BaseBo("09:00~11:00"));
        imageArrayBos.add(new BaseBo("11:00~13:00"));
        imageArrayBos.add(new BaseBo("13:00~15:00"));
        imageArrayBos.add(new BaseBo("15:00~17:00"));
        imageArrayBos.add(new BaseBo("17:00~19:00"));
        return imageArrayBos;
    }
}
