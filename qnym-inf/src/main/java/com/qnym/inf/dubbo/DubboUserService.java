package com.qnym.inf.dubbo;

import com.qnym.inf.dubbo.domain.UserInfo;
import java.util.List;

/**
 * Created by liuhaikuo on 2017/10/13.
 * @author liuhaikuo
 */
public interface DubboUserService {

    /**
     * 查询所有的用户
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 根据id查询用户
     * @return
     */
    UserInfo findById();
}
