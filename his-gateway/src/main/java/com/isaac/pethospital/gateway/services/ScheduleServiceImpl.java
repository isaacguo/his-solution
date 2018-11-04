package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.gateway.entities.BackupEntity;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    public static final String TRIGGER_NAME = "TriggerName";
    public static final String TRIGGER_GROUP = "TriggerGroup";

    public static final String JOB_NAME = "JobName";
    public static final String JOB_GROUP = "JobGroup";

    private final Scheduler scheduler;

    public ScheduleServiceImpl(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void scheduleJob(BackupEntity backupData) {

        try {
            this.scheduler.unscheduleJob(TriggerKey.triggerKey(TRIGGER_NAME, TRIGGER_GROUP));

            JobDetail jobDetail = getJobDetail();
            SimpleTrigger trigger = getTrigger(backupData);

            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            LOG.error("scheduler",e);
        }


    }

    private JobDetail getJobDetail() throws SchedulerException {
        JobDetail jobDetail = this.scheduler.getJobDetail(JobKey.jobKey(JOB_NAME, JOB_GROUP));
        if (jobDetail == null) {
            jobDetail = JobBuilder.newJob(BackupJob.class)
                    .withIdentity(JOB_NAME, JOB_GROUP)
                    .build();
        }
        return jobDetail;
    }

    private SimpleTrigger getTrigger(BackupEntity backupData) {

        if (backupData.getScheduleType().equals("bymin")) {

            return TriggerBuilder.newTrigger().withIdentity(TRIGGER_NAME, TRIGGER_GROUP)
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(30)
                            .repeatForever()).build();
        } else {
            return TriggerBuilder.newTrigger().withIdentity(TRIGGER_NAME, TRIGGER_GROUP)
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(backupData.getHourValue())
                            .repeatForever()).build();
        }
    }
}
