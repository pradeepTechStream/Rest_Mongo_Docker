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
        stage('Docker Deploy') {
                                steps {
                                    bat '''
                                    echo Stopping old container (if running)...
                                    docker stop Rest_Mongo_Docker || echo "No container to stop"
                                    docker rm Rest_Mongo_Docker || echo "No container to remove"

                                    echo Starting new container...
                                    docker run -d --name Rest_Mongo_Docker -p 8080:8080 Rest_Mongo_Docker:latest
                                    '''
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
