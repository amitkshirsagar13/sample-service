pipeline {
    agent {
        node {
            label 'slave'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}