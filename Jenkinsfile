node {

    try {
        notifyBuild('STARTED')

        checkout scm

        stage("Package & Code Analysis") {
            notifyBuild("In Package & Code Analysis")
            //withSonarQubeEnv('SonarQubeLocal') {
                sh 'mvn -B clean package sonar:sonar -Ddockerfile.skip'
            //}
        }


        /*
        stage("Quality Gate") {
            timeout(time: 1, unit: 'HOURS') {
                def qg = waitForQualityGate()
                if (qg.status != 'OK') {
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }
            }
        }
        */



        stage('Build and Push Docker Image') {
            notifyBuild("In Build and Push Docker Image")
            echo 'Build Docker Image'

            try {
                sh "docker images | grep his- | awk {'print \$3'} | xargs docker rmi --force"
            }
            catch (e) {

            }
            sh "mvn pl.project13.maven:git-commit-id-plugin:2.2.4:revision dockerfile:build dockerfile:tag@tag-version dockerfile:push@push-version dockerfile:push@push-latest"

        }

        stage('Deploy to Staging Server') {
            notifyBuild("In Deploy to Staging Server")
            def workspaceInfSlave = pwd()
            sh "cp docker-compose.yml /home/isaac/projects/ansible/playbook"
            sh "docker run --rm -v /home/isaac/projects/ansible/ssh:/root/.ssh -v /home/isaac/projects/ansible/hosts:/etc/ansible/ -v /home/isaac/projects/ansible/playbook:/root/ansible/playbook williamyeh/ansible:centos7 ansible-playbook /root/ansible/playbook/playbook.yml -c paramiko"
        }

        stage('User Acceptance Test') {
            notifyBuild("In User Acceptance Test")
            echo 'User Acceptance Test'
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
    catch (e) {
        currentBuild.result = "FAILED";
    }
    finally {
        notifyBuild(currentBuild.result)
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}] '"
    def summary = "${subject} (${env.BUILD_URL})"
    def details = """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

    // Override default values based on build status
    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#FFFF00'
    } else if (buildStatus == 'SUCCESSFUL') {
        color = 'GREEN'
        colorCode = '#00FF00'
    } else if (buildStatus.startsWith('In')) {
        color = 'BLUE'
        colorCode = '#0000FF'
    } else {
        color = 'RED'
        colorCode = '#FF0000'
    }

    // Send notifications
    slackSend(color: colorCode, message: summary)
}


