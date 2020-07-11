pipeline {
    agent {
        label { 'slave' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}