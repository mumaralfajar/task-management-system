pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
        // Make sure the tool name matches the one configured in global tool configuration
        scanner 'SonarQube'
    }
    
    stages {
        stage('SonarQube Analysis') {
            steps {
                script {
                    def sonarHostUrl = 'http://172.19.0.3:9000'
                    def scannerHome = tool 'SonarQube'

                    withEnv(["PATH+MAVEN=${tool 'jenkins-maven'}/bin"]) {
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.host.url=${sonarHostUrl}"
                    }
                }
            }
        }

        stage("Quality Gate") {
            steps {
                // Use the correct tool name for SonarQube Scanner
                waitForQualityGate abortPipeline: true, scannerName: 'SonarQube'
                echo 'Quality Gate Completed'
            }
        }
    }
}
