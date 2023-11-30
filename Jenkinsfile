pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
    }
    
    stages {
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    script {
                        def sonarHostUrl = 'http://172.19.0.3:9000'
                        def scannerHome = tool 'SonarQube';

                        withEnv(["PATH+MAVEN=${tool 'Maven'}/bin"]) {
                            sh "${scannerHome}/bin/sonar-scanner -Dsonar.host.url=${sonarHostUrl}"
                        }
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