package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.AnalysisData;

import java.util.List;

public interface IAnalysisService {

    ServerResponse<AnalysisData> getAnalysisBySellerId(String sellerName);

    ServerResponse<List<AnalysisData>> getAnalysisRank();

}
