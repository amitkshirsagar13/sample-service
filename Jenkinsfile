pipeline {
    agent {
        docker { image 'maven:3.6.1-jdk-8-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
        docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B'
            }
        }
    }
}