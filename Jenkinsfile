node {
    checkout scm

    /*
    stage("Build") {
            sh 'mvn -B -DskipTests compile'
    }
    */


    stage("Package & Code Analysis") {
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
        sh "mvn --settings settings.xml com.spotify:dockerfile-maven-plugin:1.3.7:push"
    }

    stage('Deploy to Staging') {
        echo 'Deploy to Staging Server'
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

stage("Quality Gate") {
    timeout(time: 1, unit: 'HOURS') {
        def qg = waitForQualityGate()
        if (qg.status != 'OK') {
            error "Pipeline aborted due to quality gate failure: ${qg.status}"
        }
    }
}


