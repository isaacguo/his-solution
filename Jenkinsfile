node {
    checkout scm


/*
    stage("Package & Code Analysis") {
        withSonarQubeEnv('SonarQubeLocal') {
            sh 'mvn -B clean package sonar:sonar -Ddockerfile.skip'
        }
    }

    stage("Quality Gate") {
        timeout(time: 1, unit: 'HOURS') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
        }
    }


    stage('Build and Push Docker Image') {
        echo 'Build Docker Image'

        try {
            sh "docker images | grep his- | awk {'print \$3'} | xargs docker rmi --force"
        }
        catch (e) {

        }
        sh "mvn pl.project13.maven:git-commit-id-plugin:2.2.4:revision dockerfile:build dockerfile:tag@tag-version dockerfile:push@push-version dockerfile:push@push-latest"

    }
    */

    stage('Deploy to Staging Server') {
       
        dir('../../../../ansible')
        {
           docker.image('williamyeh/ansible:centos7').inside("--volume=`pwd`/ssh:/root/.ssh --volume=`pwd`/hosts:/etc/ansible/ --volume=`pwd`/playbook:/root/ansible/playbook"){
	      cat /etc/ansible/hosts
	   }

	} 


    /*
        dir('../../../../ansible')
	{
	   
	   sh 'docker run --rm -v `pwd`/ssh:/root/.ssh -v `pwd`/hosts:/etc/ansible/ -v `pwd`/playbook:/root/ansible/playbook williamyeh/ansible:centos7 '
	}
	*/
    }

    stage('User Acceptance Test') {
        echo 'Push to Docker Registry'
    }


    if (env.BRANCH_NAME.startsWith('release')) {
        stage('Release') {
            echo 'Change Version Number'
        }
    } else if (env.BRANCH_NAME == 'master') {
        stage('Deploy to Production') {
            echo 'Do Deploy'
        }
    } else if (env.BRANCH_NAME.startsWith('PR-')) {
        stage('Pull Request') {
            echo 'Pull Request'
        }
    }

}


