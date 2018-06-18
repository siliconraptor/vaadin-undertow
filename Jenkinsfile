pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls -lart'
      }
    }
    stage('testing and build') {
      parallel {
        stage('firefox') {
          steps {
            echo 'firefox testing'
          }
        }
        stage('internet explorer') {
          steps {
            echo 'IE testing'
          }
        }
        stage('chrome') {
          steps {
            echo 'chrome testing'
          }
        }
      }
    }
    stage('finishing up') {
      steps {
        echo 'done'
      }
    }
  }
}