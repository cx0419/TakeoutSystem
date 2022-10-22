package com.cx.springboot02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cx.springboot02.mapper.Browse_historyMapper;
import com.cx.springboot02.pojo.BrowseHistory;
import com.cx.springboot02.service.IBrowseHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 陈翔
 * @since 2022-10-05
 */
@Service
public class BrowseHistoryServiceImpl extends ServiceImpl<Browse_historyMapper, BrowseHistory> implements IBrowseHistoryService {

}
