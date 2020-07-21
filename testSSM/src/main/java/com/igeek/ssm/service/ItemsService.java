package com.igeek.ssm.service;

import com.igeek.ssm.dao.ItemsMapper;
import com.igeek.ssm.pojo.Items;
import com.igeek.ssm.pojo.ItemsExample;
import com.igeek.ssm.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemsService {

    @Autowired
    private ItemsMapper mapper;

    @Transactional(readOnly = true)
    public PageVO findAll(String query, Integer pageNow){
        if(query == null){
            query = "";
        }
        if(pageNow == null){
            pageNow = 1;
        }

        ItemsExample example = new ItemsExample();
        ItemsExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike("%"+query+"%");
        Integer begin = (pageNow-1)*3;
        example.setBegin(begin);
        List<Items> itemsList = mapper.selectByExampleWithBLOBs(example);

        Integer myCounts = mapper.countByExample(example);
        Integer myPages = (Integer)(myCounts%3==0 ? myCounts/3 : myCounts/3+1);

        PageVO vo = new PageVO(pageNow,myPages,query,begin,itemsList);
        return vo;
    }


    public void add(Items items){
        mapper.insertSelective(items);
    }
}
