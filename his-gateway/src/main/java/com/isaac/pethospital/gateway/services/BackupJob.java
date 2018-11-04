package com.isaac.pethospital.gateway.services;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BackupJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(BackupJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("invoked");
    }

    private boolean runCommand(String command, String[] arguments) throws InterruptedException {
        CommandLine cmdLine = new CommandLine(command);
        cmdLine.addArguments(arguments);

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        Executor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(cmdLine, resultHandler);
            resultHandler.waitFor();
        } catch (IOException e) {
            LOG.error("executor exception is: ", e);
            return false;
        }

        return !(resultHandler.getExitValue() != 0);

    }
}
