package com.suozhang.rentaluser.common.widget;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/11/1 14:23
 */
public class MyScrollView extends ScrollView
{
    /**
     * UI
     */
    private View contentView;
    /**
     * data
     */
    private ValueAnimator apperaAnim;
    private ValueAnimator hiddenAnim;
    private int downScrollY;
    private int moveScrollY;
    private boolean isHidding;

    public MyScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                downScrollY = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveScrollY = getScrollY();
                if (moveScrollY != downScrollY)
                {
                    startHiddenAnimation();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                moveScrollY = 0;
                downScrollY = 0;
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void setAnimationView(final View animationView)
    {
        /**
         * 创建动画
         */
        hiddenAnim = ValueAnimator.ofFloat(0, animationView.getHeight());
        hiddenAnim.setDuration(500);
        hiddenAnim.setTarget(animationView);
        hiddenAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                animationView.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
        hiddenAnim.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                startApperaAnimation();
            }

            @Override
            public void onAnimationStart(Animator animation)
            {
                isHidding = true;
            }
        });

        apperaAnim = ValueAnimator.ofFloat(animationView.getHeight(), 0);
        apperaAnim.setDuration(500);
        apperaAnim.setTarget(animationView);
        apperaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                animationView.setTranslationY((Float) animation.getAnimatedValue());
            }
        });

        apperaAnim.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                isHidding = false;
            }

            @Override
            public void onAnimationStart(Animator animation)
            {
            }
        });
    }

    private void startHiddenAnimation()
    {
        if (!hiddenAnim.isRunning() && !isHidding)
        {
            hiddenAnim.start();
        }
    }

    private void startApperaAnimation()
    {
        if (!apperaAnim.isRunning())
        {
            apperaAnim.start();
        }
    }

    /**
     * 是否直接滑动到底部
     */
    protected boolean isScrollDown()
    {
        return getHeight() + getScrollY() == contentView.getHeight();
    }

    /**
     * 是否直接滑到顶部
     */
    protected boolean isScrollUp()
    {
        return getScrollY() == 0;
    }
}





