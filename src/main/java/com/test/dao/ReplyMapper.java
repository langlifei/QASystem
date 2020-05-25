package com.test.dao;

import com.test.entities.Reply;
import com.test.vo.ExtendReply;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;
import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer rID);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rID);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<ExtendReply> selectByWID(Integer wID);

    List<Reply> selectRecentReplyInWIDs(List wIDList,Integer userID);

    List<Reply> selectRecentReplyUserID(Integer userID,Integer role);
}