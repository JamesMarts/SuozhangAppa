package com.suozhang.rentaluser.feature.life.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.PayTypeBo;
import com.suozhang.rentaluser.framework.DataServer;

import java.util.List;
import java.util.Vector;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/13 16:11
 */
public class PayDialog extends Dialog {
    private Context context;
    private MyClickListenerInterface listenerInterface;
    private LayoutInflater layoutInflater;
    private int type;


    public PayDialog(Context context) {
        super(context, R.style.card_dialog);
        this.context = context;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        View view = layoutInflater.inflate(R.layout.dialog_pay, null);
        setContentView(view);


        TextView buttonConfim = view.findViewById(R.id.btn_confirm);
        TextView buttonCancle = view.findViewById(R.id.btn_cancle);
        RecyclerView rvPayType = view.findViewById(R.id.rv_pay_type);
        rvPayType.setLayoutManager(new LinearLayoutManager(context));
        rvPayType.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        final PayTypeAdapter payTypeAdapter = new PayTypeAdapter(DataServer.getPayType());
        rvPayType.setAdapter(payTypeAdapter);

        Window dialogWindow = getWindow();
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.88); // 高度设置为屏幕的0.6

        payTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                payTypeAdapter.changeState(position);
                type = DataServer.getPayType().get(position).getType();
            }
        });
        buttonConfim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenerInterface != null) listenerInterface.doConfirm(type);

            }
        });
        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setListener(MyClickListenerInterface listener) {
        this.listenerInterface = listener;
    }


    public interface MyClickListenerInterface {
        void doConfirm(int type);
    }

    public class PayTypeAdapter extends BaseQuickAdapter<PayTypeBo, BaseViewHolder> {
        private int lastPosition = -1;                                //记录上一次选中的图片位置，-1表示未选中
        private Vector<Boolean> vector = new Vector<Boolean>();

        public PayTypeAdapter(List<PayTypeBo> baseBos) {
            super(R.layout.item_pay_type, baseBos);
            for (int i = 0; i < baseBos.size(); i++) {
                vector.add(false);
            }
        }

        @Override
        protected void convert(BaseViewHolder helper, PayTypeBo item) {
            helper.setText(R.id.tv_pay_type, TextUtils.isEmpty(item.getName()) ? "" : item.getName());
            AM.image().bind(item.getImage(), (ImageView) helper.getView(R.id.iv_pay_type));
            ImageView bt_room_press = helper.getView(R.id.cbx_pay_type);
            if (vector.elementAt(helper.getPosition()) == true) {
                bt_room_press.setImageDrawable(AM.app().getResources().getDrawable(R.drawable.cbx_lock_loss_checked));
            } else {
                bt_room_press.setImageDrawable(AM.app().getResources().getDrawable(R.drawable.cbx_lock_loss_uncheck));
            }

        }

        public void changeState(int position) {
            if (lastPosition != -1)
                vector.setElementAt(false, lastPosition);                   //取消上一次的选中状态
            vector.setElementAt(!vector.elementAt(position), position);     //直接取反即可
            lastPosition = position;                                        //记录本次选中的位置
            notifyDataSetChanged();                                         //通知适配器进行更新
        }
    }
}