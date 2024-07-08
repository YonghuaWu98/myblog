package com.wuyonghua.wyhblog.admin.service;

import com.wuyonghua.wyhblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.wuyonghua.wyhblog.common.utils.Response;

public interface AdminUserService {
    /*
     * 修改用户密码
     * @return: Response
     **/
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /*
     * 获取当前用户信息
     * @return: Response
     **/
    Response queryUserInfo();
}
