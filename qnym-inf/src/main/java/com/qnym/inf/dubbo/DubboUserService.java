package com.qnym.inf.dubbo;

import com.qnym.inf.dubbo.domain.UserInfo;
import java.util.List;

/**
 * Created by liuhaikuo on 2017/10/13.
 */
public interface DubboUserService {
    List<UserInfo> findAll();
    UserInfo findById();
}
