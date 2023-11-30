pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
    }

    stages {
        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'sonar-scanner'
                    withEnv(["PATH+SONAR_SCANNER=${scannerHome}/bin"]) {
                        sh 'mvn clean install'
                        sh 'mvn clean package'
                        sh 'sonar-scanner'
                    }
                }
            }
        }

        stage("Quality Gate") {
            steps {
                waitForQualityGate abortPipeline: true
                echo 'Quality Gate Completed'
            }
        }
    }
}