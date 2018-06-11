package com.bsb.mapper;

import com.bsb.pojo.AnalysisData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAnalysisMapper {

    @Select("SELECT * FROM analysis_view WHERE id = #{sellerId}")
    AnalysisData getAnalysisBySellerId(String sellerName);

    @Select("SELECT * FROM analysis_view ORDER BY sold DESC LIMIT 0, 10")
    List<AnalysisData> getAnalysisRank();

}
