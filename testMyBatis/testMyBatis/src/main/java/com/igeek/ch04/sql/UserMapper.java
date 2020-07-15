package com.igeek.ch04.sql;

import com.igeek.pojo.UserCustom;
import com.igeek.pojo.UserQueryVO;

import java.util.List;

public interface UserMapper {

        public List<UserCustom> findList(UserQueryVO vo);
        public Integer findCounts(UserQueryVO vo);
        public List<UserCustom> findListByIds(UserQueryVO vo);

}
