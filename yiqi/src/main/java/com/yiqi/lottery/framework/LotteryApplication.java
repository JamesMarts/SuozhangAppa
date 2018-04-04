package com.yiqi.lottery.framework;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/11 16:59
 */

public class LotteryApplication extends TinkerApplication {

    public LotteryApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.yiqi.lottery.framework.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }

}