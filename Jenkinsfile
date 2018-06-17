pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls -lart'
      }
    }
    stage('') {
      steps {
        sh '''withMaven("Maven_3.5.3"){
 sh \'mvn clean install\'
}'''
        }
      }
    }
  }