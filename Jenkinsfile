node {
    checkout scm
    docker.image('maven:alpine').inside {
        writeFile file: 'settings.xml', text: "<settings><localRepository>${pwd()}/.m2repo</localRepository></settings>"
        stage("Build") {
            sh "uname -a"
            sh "pwd"
            sh 'cd src && mvn -B -s ../settings.xml -DskipTests compile'
        }

        stage("Unit Test") {
            sh "uname -a"
            sh "pwd"
            sh "cd src && mvn -B -s ../settings.xml test"
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
    if (enf.BRANCH_NAME == 'master') {
        stage('Deploy') {
            echo 'Do Deploy'
        }
    }
}
