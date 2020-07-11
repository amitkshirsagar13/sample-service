pipeline {
    agent {
        node {
            label 'slave'
        }
    }
    stages {
        stage('Git Branch Fetch') {
            steps {
                def proRepo = checkout scm
                env.gitCommit = proRepo.GIT_COMMIT
                env.gitBranch = proRepo.GIT_BRANCH.split('/')[1]
                env.shortGitCommit = "${gitCommit[0..10]}"
            }
        }
        stage('Test') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}