node {
    checkout scm

    /*
    stage("Build") {
            sh 'mvn -B -DskipTests compile'
    }
    */


    stage("Package & Code Analysis") {
        withSonarQubeEnv('SonarQubeLocal') {
            sh 'mvn -B clean package sonar:sonar -Ddockerfile.skip'
        }
    }


    stage('Build and Push Docker Image') {
        echo 'Build Docker Image'
        sh "mvn dockerfile:build && mvn dockerfile:tag@tag-version && mvn dockerfile:push@push-latest && mvn dockerfile:push@push-version"
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


