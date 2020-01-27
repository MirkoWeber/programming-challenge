pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean build'
        git(url: 'https://github.com/MirkoWeber/programming-challenge/', branch: 'mySolution')
      }
    }

  }
}