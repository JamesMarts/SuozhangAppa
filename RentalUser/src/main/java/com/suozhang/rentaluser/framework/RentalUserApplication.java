package com.suozhang.rentaluser.framework;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/11 16:59
 */

public class RentalUserApplication extends TinkerApplication {

    public RentalUserApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.suozhang.rentaluser.framework.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }

}