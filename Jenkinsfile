 pipeline {
     agent any
     stages {
           stage("clean up")
              {
                steps {
                     deleteDir()
                }
           }
           stage('clone repo') {
               steps {
                   sh 'git clone https://github.com/PoojaSakha/BookProject.git'
               }
           }
            stage('Build') {
                steps {
                  dir('BookProject') {
                    script {
                        sh 'mvn clean install'
                    }
                  }
                }
            }

            stage('Test') {
                steps {
                  dir('BookProject') {
                    script {
                        sh 'mvn test'
                    }
                  }
                }
            }
     }

}