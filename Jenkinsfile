node {
    checkout scm
    docker.image('maven:alpine').inside {
        writeFile file: 'settings.xml', text: "<settings><localRepository>${pwd()}/.m2repo</localRepository></settings>"
        stage("Build") {
            sh "uname -a"
            sh "pwd"
            sh 'mvn -B -s settings.xml -DskipTests compile'
        }

        stage("Unit Test") {
            sh "uname -a"
            sh "pwd"
            sh "mvn -B -s settings.xml test"
        }
        stage ("Code Analysis") {
	    withSonarQubeEnv('SonarQubeLocal') {
	    
	    sh 'mvn -B -s settings.xml org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
            publishHTML (target: [
	                  reportDir: 'target/site/jacoco',
			                reportFiles: 'index.html',
					              reportName: "JaCoCo Report" ])
            }
        }
    }
    stage('Build Docker Image') {
        echo 'Build Docker Image'
    }
    stage('Push to Docker Registry') {
        echo 'Push to Docker Registry'
    }

    stage('UAT') {
        echo 'Push to Docker Registry'
    }
    if (env.BRANCH_NAME.startsWith('release')) {
        stage('Release') {
            echo 'Change Version Number'
        }
    }
    if (env.BRANCH_NAME == 'master') {
        stage('Deploy') {
            echo 'Do Deploy'
        }
    }
}
