package com.isaac.pethospital.gateway.utils;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CommandRunUtil {

    private static final Logger LOG = LoggerFactory.getLogger(CommandRunUtil.class);

    public static boolean runCommand(String command, String[] arguments) throws InterruptedException, IOException {
        CommandLine cmdLine = new CommandLine(command);
        cmdLine.addArguments(arguments);

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        Executor executor = new DefaultExecutor();
        executor.setExitValue(1);
        executor.execute(cmdLine, resultHandler);
        resultHandler.waitFor();

        return !(resultHandler.getExitValue() != 0);

    }

    public static String getStackTraceString(Exception e) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String sStackTrace = sw.toString();
        return sStackTrace;
    }
}
