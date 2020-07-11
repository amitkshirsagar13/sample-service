pipeline {
    agent {
        docker { image 'maven:3.6.1-jdk-8-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}