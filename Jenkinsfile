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
                docker build -t rest_mongo_docker:latest .
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
                                    docker stop rest_mongo_docker || echo "No container to stop"
                                    docker rm rest_mongo_docker || echo "No container to remove"

                                    echo Starting new container...
                                    docker run -d --name rest_mongo_docker -p 8080:8080 rest_mongo_docker:latest
                                    '''
                                }
        }
        stage('Deploy to Kubernetes') {
                    steps {
                        writeFile file: 'kubeconfig.yaml', text: "${KUBECONFIG_CRED}"
                        withEnv(["KUBECONFIG=${WORKSPACE}/kubeconfig.yaml"]) {
                            sh 'kubectl apply -f k8s/deployment.yaml'
                            sh 'kubectl apply -f k8s/service.yaml'
                            sh 'kubectl rollout status deployment/my-rest-api'
                        }
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
