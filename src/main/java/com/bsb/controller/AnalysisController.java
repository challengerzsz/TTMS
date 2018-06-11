package com.bsb.controller;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.pojo.AnalysisData;
import com.bsb.pojo.User;
import com.bsb.service.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/analysis")
public class AnalysisController {

    @Autowired
    private IAnalysisService analysisService;

    @GetMapping("/{sellerName}")
    public ServerResponse<AnalysisData> getAnalysisBySellerId(HttpSession session, @PathVariable("sellerName") String sellerName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 2) {
            return ServerResponse.createByErrorMsg("身份信息认证失败，请重新登陆");
        }

        return analysisService.getAnalysisBySellerId(sellerName);
    }


    @GetMapping("/rank")
    public ServerResponse<List<AnalysisData>> getAnalysisRank(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 2) {
            return ServerResponse.createByErrorMsg("身份信息认证失败，请重新登陆");
        }

        return analysisService.getAnalysisRank();
    }
}
