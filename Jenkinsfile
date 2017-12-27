node {
    checkout scm
    stage("Build") {
	    sh "whoami"
            sh "uname -a"
            sh "pwd"
            sh 'mvn -B -DskipTests compile'
    }

    
    stage ("Code Analysis") {
	    withSonarQubeEnv('SonarQubeLocal') {
	    
	    sh 'mvn -B package sonar:sonar' 
            }
    }
    
            
    stage('Build Docker Image') {
        echo 'Build Docker Image'
        sh "mvn com.spotify:dockerfile-maven-plugin:1.3.7:build"
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

stage ("Quality Gate") {
            timeout(time: 1, unit: 'HOURS' ){
                def qg= waitForQualityGate()
                if (qg.status != 'OK') {
                     error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }
            }
    }


