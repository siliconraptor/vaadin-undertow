pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls -lart'
      }
    }
    stage('error') {
      steps {
        sh '''withMaven(jdk: \'JDK8_172\', maven: \'maven_3.5.3\') {
    sh \'mvn clean install\'
}'''
        }
      }
    }
  }