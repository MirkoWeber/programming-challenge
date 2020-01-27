pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        git(url: 'https://github.com/MirkoWeber/programming-challenge/', branch: 'mySolution')
        sh 'mvn clean build'
      }
    }

  }
}