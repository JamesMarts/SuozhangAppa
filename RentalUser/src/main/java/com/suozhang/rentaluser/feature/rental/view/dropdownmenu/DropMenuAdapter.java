package com.suozhang.rentaluser.feature.rental.view.dropdownmenu;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.baiiu.filter.FilterBaseBo;
import com.baiiu.filter.adapter.MenuAdapter;
import com.baiiu.filter.adapter.SimpleTextAdapter;
import com.baiiu.filter.interfaces.OnFilterDoneListener;
import com.baiiu.filter.interfaces.OnFilterItemClickListener;
import com.baiiu.filter.typeview.DoubleListView;
import com.baiiu.filter.typeview.SingleListView;
import com.baiiu.filter.util.CommonUtil;
import com.baiiu.filter.util.UIUtil;
import com.baiiu.filter.view.FilterCheckedTextView;
import com.suozhang.framework.component.http.Host;
import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.utils.SPUtil;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.widget.DialogHelper;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity.FilterData;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity.FilterType;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity.FilterUrl;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.view.betterDoubleGrid.BetterDoubleGridView;
import com.suozhang.rentaluser.framework.api.RentApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.suozhang.rentaluser.framework.Config.KEY_AREA_ID;

/**
 * author: baiiu
 * date: on 16/1/17 21:14
 * description:
 */
public class DropMenuAdapter implements MenuAdapter {
    private final Context mContext;
    private OnFilterDoneListener onFilterDoneListener;
    private String[] titles;
    private String mAreaId = "";
    DialogHelper dialogHelper;

    public DropMenuAdapter(Context context, String[] titles, OnFilterDoneListener onFilterDoneListener) {
        this.mContext = context;
        this.titles = titles;
        this.onFilterDoneListener = onFilterDoneListener;
        BaseBo baseBo = (BaseBo) SPUtil.readObj(context, KEY_AREA_ID);
        if (baseBo != null) {
            mAreaId = baseBo.getId();
        }
        dialogHelper = new DialogHelper(context);
    }

    @Override
    public int getMenuCount() {
        return titles.length;
    }

    @Override
    public String getMenuTitle(int position) {
        return titles[position];
    }

    @Override
    public int getBottomMargin(int position) {
        if (position == 3) {
            return 0;
        }

        return UIUtil.dp(mContext, 140);
    }

    @Override
    public View getView(int position, FrameLayout parentContainer) {
        View view = parentContainer.getChildAt(position);

        switch (position) {
            case 0:
                view = createDoubleListView();
                break;
            case 1:
                view = createSingleListView();
                break;
            case 2:
                view = createSingleGridView();
                break;
            case 3:
                view = createBetterDoubleGrid();
                break;
        }
        return view;
    }

    private View createSingleListView() {
        SingleListView<FilterBaseBo> singleListView = new SingleListView<FilterBaseBo>(mContext)
                .adapter(new SimpleTextAdapter<FilterBaseBo>(null, mContext) {

                    @Override
                    public FilterBaseBo provideText(FilterBaseBo string) {
                        return string;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<FilterBaseBo>() {
                    @Override
                    public void onItemClick(FilterBaseBo item) {
                        FilterUrl.instance().singleListPosition = item;
                        FilterUrl.instance().position = 1;
                        FilterUrl.instance().positionTitle = item;

                        onFilterDone();
                    }
                });


        singleListView.setList(FilterData.getRentMoney(), -1);

        return singleListView;
    }


    private View createDoubleListView() {
        final DoubleListView<FilterType, FilterBaseBo, FilterBaseBo> comTypeDoubleListView = new DoubleListView<FilterType, FilterBaseBo, FilterBaseBo>(mContext)
                .leftAdapter(new SimpleTextAdapter<FilterType>(null, mContext) {
                    @Override
                    public FilterBaseBo provideText(FilterType filterType) {
                        return filterType.desc;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 0), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                    }
                })
                .rightAdapter(new SimpleTextAdapter<FilterBaseBo>(null, mContext) {
                    @Override
                    public FilterBaseBo provideText(FilterBaseBo s) {
                        return s;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 0), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                        checkedTextView.setBackgroundResource(android.R.color.white);
                    }
                }).endAdapter(new SimpleTextAdapter<FilterBaseBo>(null, mContext) {
                    @Override
                    public FilterBaseBo provideText(FilterBaseBo filterBaseBo) {
                        return filterBaseBo;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        checkedTextView.setPadding(UIUtil.dp(mContext, 0), UIUtil.dp(mContext, 15), 0, UIUtil.dp(mContext, 15));
                        checkedTextView.setBackgroundResource(android.R.color.white);
                    }
                })
                .onLeftItemClickListener(new DoubleListView.OnLeftItemClickListener<FilterType, FilterBaseBo, FilterBaseBo>() {
                    @Override
                    public List<FilterBaseBo> provideRightList(FilterType item, int position) {
                        List<FilterBaseBo> child = item.child;
                        if (CommonUtil.isEmpty(child)) {
                            FilterUrl.instance().doubleListLeft = item.desc;
                            FilterUrl.instance().doubleListRight = null;

                            FilterUrl.instance().position = 0;
                            FilterUrl.instance().positionTitle = item.desc;

                            onFilterDone();
                        }

                        return child;
                    }
                })
                .onRightItemClickListener(new DoubleListView.OnRightItemClickListener<FilterType, FilterBaseBo, FilterBaseBo>() {
                    @Override
                    public List<FilterBaseBo> onRightItemClick(FilterBaseBo childItem, int position) {
                        // FilterUrl.instance().doubleListLeft = item.desc;
                        FilterUrl.instance().doubleListRight = childItem;

                        List<FilterBaseBo> endList = null;
                        if (childItem.getScreeningInfo() != null && childItem.getScreeningInfo().size() > 0) {
                            endList = childItem.getScreeningInfo();
                        } else {
                            FilterUrl.instance().position = 0;
                            FilterUrl.instance().positionTitle = childItem;
                            onFilterDone();
                        }
                        return endList;
                    }


                }).onEndItemClickListener(new DoubleListView.OnEndItemClickListener<FilterBaseBo>() {
                    @Override
                    public void onEndItemClick(FilterBaseBo endItem) {
                        FilterUrl.instance().position = 0;
                        FilterUrl.instance().positionTitle = endItem;
                        FilterUrl.instance().doubleListEnd = endItem;
                        onFilterDone();
                    }
                });


        final List<FilterType> list = new ArrayList<>();
        AM.api().createApiService(Host.DEBUG_LOCAL.value(), RentApi.class).getNearList(mAreaId)
                .compose(RxDataProcessFactory.<List<FilterBaseBo>>dataPrepAndIoToMainTransformer())
                .subscribe(new Observer<List<FilterBaseBo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        dialogHelper.showDialog(d);
                    }

                    @Override
                    public void onNext(List<FilterBaseBo> nearBos) {
                        dialogHelper.dismissDialog();

                        for (int i = 0; i < nearBos.size(); i++) {
                            list.add(new FilterType(nearBos.get(i), nearBos.get(i).getScreeningInfo()));
                            //初始化选中.
                        }


                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).child.add(0, new FilterBaseBo("", "不限"));

                        }
//
//
//                        list.add(0, new FilterType(new FilterBaseBo("", "不限"), null));
                        if (list != null && list.size() > 0) {
                            comTypeDoubleListView.setLeftList(list, 0);
                            comTypeDoubleListView.setRightList(list.get(0).child, -1);
                            if (list.get(0).child.get(0).getScreeningInfo() != null) {
                                comTypeDoubleListView.setEndList(list.get(0).child.get(0).getScreeningInfo(), -1);
                            }
                            comTypeDoubleListView.getLeftListView().setBackgroundColor(mContext.getResources().getColor(R.color.b_c_fafafa));
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        dialogHelper.dismissDialog();
                        T.showShort(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        dialogHelper.dismissDialog();
                    }
                });


        return comTypeDoubleListView;
    }


    private View createSingleGridView() {

        final SingleListView<FilterBaseBo> singleGridView = new SingleListView<FilterBaseBo>(mContext)
                .adapter(new SimpleTextAdapter<FilterBaseBo>(null, mContext) {
                    @Override
                    public FilterBaseBo provideText(FilterBaseBo string) {
                        return string;
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<FilterBaseBo>() {
                    @Override
                    public void onItemClick(FilterBaseBo item) {
                        FilterUrl.instance().singleGridPosition = item;

                        FilterUrl.instance().position = 2;
                        FilterUrl.instance().positionTitle = item;

                        onFilterDone();
                    }
                });

        AM.api().createApiService(Host.DEBUG_LOCAL.value(), RentApi.class).getHouseType()
                .compose(RxDataProcessFactory.<List<FilterBaseBo>>dataPrepAndIoToMainTransformer())
                .subscribe(new Observer<List<FilterBaseBo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<FilterBaseBo> nearBos) {
                        List<FilterBaseBo> filterBaseBos = new ArrayList<>();
                        filterBaseBos = nearBos;
                        filterBaseBos.add(0, new FilterBaseBo(null, "不限"));
                        singleGridView.setList(nearBos, -1);
                    }

                    @Override
                    public void onError(Throwable e) {
                        T.showShort(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return singleGridView;
    }


    private View createBetterDoubleGrid() {

        final BetterDoubleGridView betterDoubleGridView = new BetterDoubleGridView(mContext);
        AM.api().createApiService(Host.DEBUG_LOCAL.value(), RentApi.class).getOrientation()
                .compose(RxDataProcessFactory.<List<FilterBaseBo>>dataPrepAndIoToMainTransformer())
                .subscribe(new Observer<List<FilterBaseBo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<FilterBaseBo> nearBos) {
                        betterDoubleGridView.setmTopGridData(FilterData.getTypes())
                                .setmBottomGridList(nearBos)
                                .setOnFilterDoneListener(onFilterDoneListener)
                                .build();
                    }

                    @Override
                    public void onError(Throwable e) {
                        T.showShort(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        return betterDoubleGridView;
    }


    private void onFilterDone() {
        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(0, "", "");
        }
    }

}
