package com.isaac.pethospital.gateway.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:git.properties"})
public class MyGitProperties {

    @Value("${git.commit.id.abbrev}")
    private String gitCommitIdAbbrev;

    public String getGitCommitIdAbbrev()
    {
        return this.gitCommitIdAbbrev;
    }


}
