pipeline {
    agent {
        node {
            label 'slave'
        }
    }
    stages {
        stage('Git Branch Fetch') {
            steps {
                sh 'git clone https://github.com/amitkshirsagar13/sample-service $(pwd)'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}