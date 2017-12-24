node {
    checkout scm
    docker.image('maven:alpine').inside {
        writeFile file: 'settings.xml', text: "<settings><localRepository>${pwd()}/.m2repo</localRepository></settings>"
        stage("Build") {
            sh "uname -a"
            sh 'cd src && mvn -B -s ../settings.xml -DskipTests compile'
        }

        stage("Test") {
            sh "uname -a"
            sh "mvn -B -s settings.xml test"
        }
    }
    stage('Build Docker Image') {
        echo 'Build Docker Image'
    }
    stage('Push to Docker Registry') {
        echo 'Push to Docker Registry'
    }
}
