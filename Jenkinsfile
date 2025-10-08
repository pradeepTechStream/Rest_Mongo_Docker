pipeline {
    agent any
    tools {
        jdk 'JDK17'
    }
    triggers {
        cron('H/30 * * * *')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pradeepTechStream/Rest_Mongo_Docker.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Docker Build') {
            steps {
                bat '''
                echo Building Docker image...
                docker build -t Rest_Mongo_Docker:latest .
                '''
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
           }
        }
    }
    post {
       success {
           echo "Build and deployment successful!"
       }
       failure {
           echo "Build failed. Skipping deployment."
       }
    }
}
