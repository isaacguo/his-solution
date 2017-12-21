FROM jenkins:latest

MAINTAINER Isaac Guo <yue_guo@keysight.com>


#USER root

COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/executors.groovy


# Install Jenkins Plugins
RUN /usr/local/bin/install-plugins.sh \
      workflow-aggregator \
      docker-workflow \
      slack \
      copyartifact \
      jobConfigHistory \
      build-timeout \
      disk-usage \
      email-ext \
      sonar \
      ec2 \
      build-monitor-plugin \
      github \
      matrix-auth 
      
      


# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false




RUN git config --global user.email "Isaac_Guo@163.com" && \
    git config --global user.name "Isaac Guo"



