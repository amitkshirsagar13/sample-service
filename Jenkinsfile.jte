pipeline {
  node {
    stages {
      stage('Build') {
        steps {
          build()
        }
      }
    }
  }
}
