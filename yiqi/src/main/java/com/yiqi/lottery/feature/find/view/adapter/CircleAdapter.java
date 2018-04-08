package com.yiqi.lottery.feature.find.view.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.CircleBo;
import com.yiqi.lottery.framework.DataServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleAdapter extends BaseQuickAdapter<CircleBo,BaseViewHolder> {
    private GetCheckedValue getCheckedValue;

    // 存储勾选框状态的map集合  解决滑动的复用问题
    private Map<Integer, Boolean> map = new HashMap<>();

    public CircleAdapter() {
        super(R.layout.item_find_circle);
    }

    @Override
    protected void convert(BaseViewHolder helper, CircleBo item) {
        CheckBox checkBox=helper.getView(R.id.cbx_find_circle_like);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                map.put(helper.getAdapterPosition(), b);
                getCheckedValue.getValue("aaaa");
            }
        });
        RecyclerView rvImg=helper.getView(R.id.rv_find_circle_img);
        rvImg.setLayoutManager(new GridLayoutManager(AM.app(),4));
        List<String> img=DataServer.getImgData();
        if (img.size()>4){
            img= img.subList(0,4);
        }
        ImgAdapter imgAdapter=new ImgAdapter(img);
        rvImg.setAdapter(imgAdapter);

        if (map.get(helper.getAdapterPosition()) == null) {
            map.put(helper.getAdapterPosition(), false);
        }

        checkBox.setChecked(map.get(helper.getAdapterPosition()));

    }


     class ImgAdapter extends   BaseQuickAdapter<String,BaseViewHolder> {

         public ImgAdapter( @Nullable List<String> data) {
             super(R.layout.item_find_circle_img, data);
         }

         @Override
         protected void convert(BaseViewHolder helper, String item) {
             AM.image().bind(item,helper.getView(R.id.iv_find_circle_img));
         }
     }
    public interface GetCheckedValue {
        void getValue(String ids);
    }

    public void setOnItemChecked(GetCheckedValue getCheckedValue) {
        this.getCheckedValue = getCheckedValue;
    }

}
