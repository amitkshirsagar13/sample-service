pipeline {
  stage {
    stage('Build') {
      steps {
        build()
      }
    }
  }
}
