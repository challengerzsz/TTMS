package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.mapper.IAnalysisMapper;
import com.bsb.pojo.AnalysisData;
import com.bsb.service.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisService implements IAnalysisService {

    @Autowired
    private IAnalysisMapper analysisMapper;

    @Override
    public ServerResponse<AnalysisData> getAnalysisBySellerId(Integer sellerId) {
        AnalysisData analysisData = analysisMapper.getAnalysisBySellerId(sellerId);
        if (analysisData == null) {
            return ServerResponse.createByErrorMsg("查询失败");
        }

        return ServerResponse.createBySuccess("查询成功", analysisData);
    }

    @Override
    public ServerResponse<List<AnalysisData>> getAnalysisRank() {

        List<AnalysisData> analysisData = analysisMapper.getAnalysisRank();
        if (analysisData.size() == 0) {
            return ServerResponse.createByErrorMsg("获取分析排行榜为空");
        }

        return ServerResponse.createBySuccess("获取成功", analysisData);
    }
}
