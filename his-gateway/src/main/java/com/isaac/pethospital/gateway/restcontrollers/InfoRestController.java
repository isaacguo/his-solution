package com.isaac.pethospital.gateway.restcontrollers;

import com.isaac.pethospital.gateway.properties.MyGitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app-info")
public class InfoRestController {

    @Autowired
    MyGitProperties myGitProperties;

    @Value("${app.version}")
    private String appVersion;


    @RequestMapping("/getVersion")
    public String getAppVersion() {
        return appVersion;
    }

    @RequestMapping("/gitCommitIdAbbrev")
    public String getGitCommitIdAbbrev() {
        return this.myGitProperties.getGitCommitIdAbbrev();
    }

}
