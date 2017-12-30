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
        sh "docker images | grep his- | awk {'print \$3'} | xargs docker rmi --force"
        sh "mvn pl.project13.maven:git-commit-id-plugin:2.2.4:revision dockerfile:build dockerfile:tag@tag-version dockerfile:push@push-version dockerfile:push@push-latest"
        sh "docker images -q --filter \"dangling=true\" | xargs docker rmi --force"
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


